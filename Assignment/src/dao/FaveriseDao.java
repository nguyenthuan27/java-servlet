package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import common.JPSUtils;
import models.Favorite;
import models.FavoriteUserVideo;
import models.ListLikeVideo;
import models.Report;
import models.Share;
import models.ShareList;
import models.Users;
import models.Videos;

public class FaveriseDao {

	EntityManager em = JPSUtils.getEntityManager();

	public List<Favorite> findFaverByUserID(String userID) {

		List<Favorite> listFaver = null;
		listFaver = em.find(Users.class, userID).getFavorite();

		return listFaver;

	}

	public List<Favorite> findFaverByVideoID(String userID) {

		List<Favorite> listFaver = null;
		listFaver = em.find(Videos.class, userID).getFavorites();

		return listFaver;

	}

	public List<Report> getReport() {

		List<Report> listReport = null;
		try {
			String hql = "Select new models.Report(f.videos.title, count(f), max(f.likedate), min(f.likedate)) from Favorite f group by f.videos.title";
			TypedQuery<Report> query = em.createQuery(hql, Report.class);
			listReport = query.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {

		}
		return listReport;
	}

	public List<FavoriteUserVideo> getUserLikeVideo() {
		List<FavoriteUserVideo> listUserLike = null;
		try {
			String hql = "Select new FavoriteUserVideo(f.users.id,f.users.fullname,f.users.email,f.likedate) from Favorite  f";
			TypedQuery<FavoriteUserVideo> query = em.createQuery(hql, FavoriteUserVideo.class);
			// query.setParameter("videoId", idvideo);
			listUserLike = query.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {

		}
		return listUserLike;
	}

	public List<ListLikeVideo> geLikeVideo() {
		List<ListLikeVideo> listLike = null;
		try {
			String hql = "Select new ListLikeVideo(f.users.id,f.users.fullname,f.users.email,f.likedate,f.videos.title) from Favorite  f";
			TypedQuery<ListLikeVideo> query = em.createQuery(hql, ListLikeVideo.class);
			// query.setParameter("videoId", idvideo);
			listLike = query.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {

		}
		return listLike;
	}

	public List<ShareList> getShare() {

		List<ShareList> listLike = null;
		try {
			String hql = "select DISTINCT new ShareList(o.users.id, o.users.email, o.emails, o.sharedate) from Share o ";
			TypedQuery<ShareList> query = em.createQuery(hql, ShareList.class);
			listLike = query.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {

		}
		return listLike;
	}

	public List<FavoriteUserVideo> baocao(String ad) {
		List<FavoriteUserVideo> list = null;
		try {
			em.getTransaction().begin();
			TypedQuery<FavoriteUserVideo> query = em.createQuery(
					"select DISTINCT new FavoriteUserVideo(o.users.id, o.users.fullname, o.users.email, o.likedate) from Favorite o where o.videos.title=?0",
					FavoriteUserVideo.class);
			query.setParameter(0, ad);
			list = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			System.out.print(e.toString());
		}

		return list;
	}

	public List<Videos> findVideoByUserID(String id) {
		String jpQl = "Select f.videos from Favorite f where f.users.id =:id";
		TypedQuery<Videos> query = em.createQuery(jpQl, Videos.class);
		query.setParameter("id", id);
		List<Videos> listVideos = query.getResultList();
		return listVideos;
	}

	public Boolean likeVideo(Favorite favor) {
		em.getTransaction().begin();
		Boolean insertResult = false;
		try {
			em.persist(favor);
			em.getTransaction().commit();
			insertResult = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		// Return
		return insertResult;
	}

	public Favorite findFacvoriteById(String Id) {
		Favorite fas = em.find(Favorite.class, Id);
		return fas;
	}

	public Boolean share(Share shares) {
		em.getTransaction().begin();
		Boolean insertResult = false;
		try {
			em.persist(shares);
			em.getTransaction().commit();
			insertResult = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		// Return
		return insertResult;
	}

//	public List<Favorite> findfavorlike(String id) {
//		List<Favorite> list = null;
//		try {
//			
//			String jpQl = "Select f from Favorite f where f.videos.id = :id";
//			TypedQuery<Favorite> query = em.createQuery(jpQl, Favorite.class);
//			query.setParameter("id",id);
//			List<Favorite> listVideos = query.getResultList();
//			return listVideos;
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return list;
//	}

	public Boolean deletelike(String Id) {
		em.getTransaction().begin();
		Boolean delResult = false;
		try {
			VideoDao fav = new VideoDao();
			List<Favorite> ad1 = em.find(Videos.class, Id).getFavorites();
			for (Favorite a : ad1) {
				em.remove(a);
			}
			em.getTransaction().commit();
			delResult = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		// Return
		return delResult;
	}

	// Phân trang

	public Integer checknext1(String so1) {
		Integer kq = null;
		try {
			VideoDao dao = new VideoDao();
			List<Videos> list1 = dao.findAllVideo();
			for (int i = 0; i < list1.size(); i++) {
				if (list1.get(i).getId().equals(so1)) {
					kq = i + 1;
				}
			}
		} catch (Exception e) {
			System.out.print(e.toString());
		}
		return kq;

	}

	public List<Videos> pt1(int so1, int so2) {
		List<Videos> list = null;
		try {
			TypedQuery<Videos> query;

			query = em.createQuery("select o from Videos o", Videos.class);

			query.setFirstResult(so1);
			query.setMaxResults(so2);
			list = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.toString());
		}
		return list;

	}
}
