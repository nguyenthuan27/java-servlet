package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import common.JPSUtils;
import models.Users;
import models.Videos;

public class VideoDao {
	EntityManager em = JPSUtils.getEntityManager();

	@SuppressWarnings("finally")
	public List<Videos> findAllVideo() {
		List<Videos> listUser = null;
		try {
			String hql = "Select o from Videos o";
			TypedQuery<Videos> query = em.createQuery(hql, Videos.class);
			listUser = query.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			return listUser;
		}
	}
	public List<Videos> paging(){
		List<Videos> listVideo = null;
		try {
			String hql = "Select o from Videos o";
			TypedQuery<Videos> query = em.createQuery(hql, Videos.class);
			query.setFirstResult(5);
			query.setMaxResults(4);
			listVideo = query.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} 
			return listVideo;

	}
	
	
	/*
	 * Create user
	 */

	public Boolean createVideo(Videos video) {
		em.getTransaction().begin();
		Boolean insertResult = false;
		try {
			em.persist(video);
			em.getTransaction().commit();
			insertResult = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		// Return
		return insertResult;
	}

	/*
	 * Update user
	 */

	public Boolean updateVideo(Videos video) {
		em.getTransaction().begin();
		Boolean updateResult = false;
		try {
			em.merge(video);
			em.getTransaction().commit();
			updateResult = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		// Return
		return updateResult;
	}

	/*
	 * Delete user
	 */
	public Boolean deleteVideo(String Id) {
		em.getTransaction().begin();
		Boolean delResult = false;
		try {
			Videos video = findVideoById(Id);
			em.remove(video);
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
	public Videos findVideoById(String Id) {
		Videos videoDel = em.find(Videos.class, Id);
		return videoDel;
	}
}
