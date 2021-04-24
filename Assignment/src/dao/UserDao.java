package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import common.JPSUtils;
import models.FavoriteUserVideo;
import models.ListLikeVideo;
import models.Users;

public class UserDao {
	EntityManager em = JPSUtils.getEntityManager();

	@SuppressWarnings("finally")
	public List<Users> findAllUser() {
		List<Users> listUser = null;
		try {
			
			String hql = "Select o from Users o";
			TypedQuery<Users> query = em.createQuery(hql, Users.class);
			listUser = query.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			return listUser;
		}
	}

	/*
	 * Create user
	 */

	public Boolean createUser(Users user) {
		em.getTransaction().begin();
		Boolean insertResult = false;
		try {
			em.persist(user);
			em.getTransaction().commit();
			insertResult = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		// Return
		return insertResult;
	}

	/*
	 * Update user
	 */

	public Boolean updateUser(Users user) {
		em.getTransaction().begin();
		Boolean updateResult = false;
		try {
			em.merge(user);
			em.getTransaction().commit();
			updateResult = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		// Return
		return updateResult;
	}

	/*
	 * Delete user
	 */
	public Boolean deleteUser(String Id) {
		em.getTransaction().begin();
		Boolean delResult = false;
		try {
			Users userDel = findUserById(Id);
			em.remove(userDel);
			em.getTransaction().commit();
			delResult = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		// Return
		return delResult;
	}

	/*
	 * Find user by Id
	 */
	public Users findUserById(String Id) {
		Users userDel = em.find(Users.class, Id);
		return userDel;
	}

//	Thay đổi mật khẩu

	public void changePassword(String username, String oldpass, String newpass) {
		em.getTransaction().begin();
		String sql = "Select f from Users f where f.id = :username and f.password = :password";
		try {
			TypedQuery<Users> query = em.createQuery(sql, Users.class);
			query.setParameter("username", username);
			query.setParameter("password", oldpass);
			Users user = query.getSingleResult();
			user.setPassword(newpass);
			em.merge(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
		}
	}
	
	
	// Check login
	public Users checkLogin(String id, String password) {
		// TODO Auto-generated method stub
		Users users = null;
		try {

			System.out.println(id);
			System.out.println(password);
			String jpQl = "SELECT f FROM Users f WHERE f.id =:id and f.Password=:password";

			TypedQuery<Users> query = em.createQuery(jpQl, Users.class);
			query.setParameter("id", id);
			query.setParameter("password", password);

			users = query.getSingleResult();
			// System.out.println(users.getEmail());

		} catch (Exception e) {
			// TODO: handle exception
		}

		return users;
	}
}
