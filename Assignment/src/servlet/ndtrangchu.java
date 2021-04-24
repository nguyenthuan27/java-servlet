package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import common.SessionUtils;
import common.sendmail;
import dao.FaveriseDao;
import dao.UserDao;
import dao.VideoDao;
import models.ChangePassword;
import models.Favorite;
import models.Share;
import models.Users;
import models.Videos;

/**
 * Servlet implementation class ndtrangchu
 */
@WebServlet({ "/nguoidung/danhsach", "/nguoidung/xemvideo/*", "/nguoidung/share/*", "/nguoidung/send/*",
		"/nguoidung/yeuthich", "/nguoidung/dangnhap", "/nguoidung/quenmk", "/nguoidung/quenmk/laymk",
		"/nguoidung/dangki", "/nguoidung/dangki/themtk", "/nguoidung/doimk", "/nguoidung/doimk/doi",
		"/nguoidung/thaydoitt", "/nguoidung/thaydoitt/updatett", "/nguoidung/danhsach/like/*",
		"/nguoidung/danhsach/dish/*", "/nguoidung/dau", "/nguoidung/cuoi", "/nguoidung/len/*", "/nguoidung/xuong/*" })
public class ndtrangchu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FaveriseDao dao1 = new FaveriseDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ndtrangchu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		int soluong = 6;
		if (uri.contains("danhsach")) {
			List<Videos> list = dao1.pt1(0, soluong);
			VideoDao vdao = new VideoDao();
			List<Videos> items = vdao.findAllVideo();
			if (uri.contains("like")) {
				try {
					Users username = (Users) request.getSession().getAttribute("username");
					String iduser = username.getId();
					FaveriseDao fdao = new FaveriseDao();
					Favorite fa = new Favorite();
					Videos vid = new Videos();
					Users user = new Users();
					user.setId(iduser);
					fa.setVideos(new VideoDao().findVideoById(id));
					fa.setUsers(new UserDao().findUserById(iduser));
					fa.setLikedate(new Date());
					fdao.likeVideo(fa);

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println("thất bại");
				}
			} else if (uri.contains("dish")) {
				FaveriseDao fav = new FaveriseDao();
				Boolean dl = fav.deletelike(id);
				if (dl == true) {
					System.out.println("ok");
				} else {
					System.out.println("loi1");
				}
				request.setAttribute("view3", "/views/nguoidung/yeuthich.jsp");
			}
			request.setAttribute("items", list);
			request.setAttribute("view3", "/views/nguoidung/danhsach.jsp");
		} else if (uri.contains("xemvideo")) {
			VideoDao vdao = new VideoDao();
			List<Videos> items = vdao.findAllVideo();
			request.setAttribute("ad", vdao.findVideoById(id));
			request.setAttribute("view3", "/views/nguoidung/xemvideo.jsp");

		} else if (uri.contains("share")) {
			request.setAttribute("ad", id);
			request.setAttribute("view3", "/views/nguoidung/share.jsp");
		} else if (uri.contains("send")) {
			VideoDao vdao = new VideoDao();
			List<Videos> items = vdao.findAllVideo();
			try {
				Users username = (Users) request.getSession().getAttribute("username");
				String iduser = username.getId();
				FaveriseDao fdao = new FaveriseDao();
				Share sha = new Share();

				BeanUtils.populate(sha, request.getParameterMap());
				sha.setVideos(new VideoDao().findVideoById(id));
				sha.setUsers(new UserDao().findUserById(iduser));
				sha.setSharedate(new Date());
				fdao.share(sha);

				String nhan = request.getParameter("emails");
				String tieude = "Link Share";
				String content = "Video YouTube" + new VideoDao().findVideoById(id).getDescriptions();
				sendmail.Send(nhan, tieude, content);
				request.setAttribute("message", "Thông tin mật khẩu đã gửi về mail của bạn");

				request.setAttribute("items", items);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("thất bại");
			}
			request.setAttribute("view3", "/views/nguoidung/share.jsp");
		} else if (uri.contains("yeuthich")) {
			this.yeuthich(request, response);
			request.setAttribute("view3", "/views/nguoidung/yeuthich.jsp");
		} else if (uri.contains("dangnhap")) {
			request.setAttribute("view3", "/views/login/dangnhap.jsp");

		} else if (uri.contains("quenmk")) {
			this.quemk(request, response);
			request.setAttribute("view3", "/views/nguoidung/quenmk.jsp");

		} else if (uri.contains("dangki")) {
			this.dangki(request, response);
			request.setAttribute("view3", "/views/nguoidung/dangki.jsp");

		} else if (uri.contains("doimk")) {
			this.doimk(request, response);
			request.setAttribute("view3", "/views/nguoidung/doimk.jsp");

		} else if (uri.contains("thaydoitt")) {
			this.thaydoitt(request, response);
			request.setAttribute("view3", "/views/nguoidung/thaydoitt.jsp");
		} else if (uri.contains("dau")) {
			FaveriseDao dao1 = new FaveriseDao();

			List<Videos> list = dao1.pt1(0, soluong);

			request.setAttribute("items", list);
			request.setAttribute("view3", "/views/nguoidung/danhsach.jsp");
		} else if (uri.contains("cuoi")) {
			VideoDao vd = new VideoDao();
			List<Videos> list = null;
			FaveriseDao dao1 = new FaveriseDao();
			List<Videos> cuoi = vd.findAllVideo();
			int vitri = cuoi.size() % soluong;
			if (vitri != 0) {
				list = dao1.pt1(cuoi.size() - vitri, soluong);
			} else {
				list = dao1.pt1(cuoi.size() - soluong, soluong);
			}
			request.setAttribute("items", list);
			request.setAttribute("view3", "/views/nguoidung/danhsach.jsp");
		} else if (uri.contains("len")) {
			List<Videos> cuoi;
			VideoDao vd = new VideoDao();
			int so = dao1.checknext1(id);
			cuoi = vd.findAllVideo();
			List<Videos> list = null;
			int vitri = cuoi.size() % soluong;
			if (so >= (cuoi.size() - soluong)) {
				if (vitri != 0) {
					list = dao1.pt1(cuoi.size() - vitri, soluong);
				} else {
					list = dao1.pt1(cuoi.size() - soluong, soluong);
				}
				request.setAttribute("tb", "đang ở cuối");
			} else {
				list = dao1.pt1(so + soluong - 1, soluong);
			}

			request.setAttribute("items", list);
			request.setAttribute("view3", "/views/nguoidung/danhsach.jsp");
		} else if (uri.contains("xuong")) {
			List<Videos> cuoi;
			VideoDao vd = new VideoDao();
			List<Videos> list = null;
			int so = dao1.checknext1(id);
			cuoi = vd.findAllVideo();
			if (so == soluong || so == 1) {
				request.setAttribute("tb", "đang ở đầu");
				list = dao1.pt1(0, soluong);
			} else {
				list = dao1.pt1(so - soluong - 1, soluong);
			}

			request.setAttribute("items", list);
			request.setAttribute("view3", "/views/nguoidung/danhsach.jsp");
		}

		request.getRequestDispatcher("/views/nguoidung/nguoidung.jsp").forward(request, response);
	}

	protected void yeuthich(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Users username = (Users) request.getSession().getAttribute("username");
		if (username == null) {
			request.getRequestDispatcher("/views/login/dangnhap.jsp").forward(request, response);
			return;
		} else {
			try {
				FaveriseDao adao = new FaveriseDao();
				List<Videos> videolike = adao.findVideoByUserID(username.getId());
				request.setAttribute("videolike", videolike);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}

	protected void quemk(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		try {
			UserDao udao = new UserDao();
			String username = request.getParameter("username");
			Users user = udao.findUserById(username);
			if (uri.contains("laymk")) {
				String nhan = request.getParameter("email");
				String tieude = "Lấy lại mật khẩu";
				String content = user.getPassword();
				sendmail.Send(nhan, tieude, content);
				request.setAttribute("message", "Thông tin mật khẩu đã gửi về mail của bạn");
			}

		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("message", "User Name Không tồn tại");
		}
	}

	protected void dangki(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		try {
			Users users = new Users();
			UserDao dao = new UserDao();
			if (uri.contains("themtk")) {
				BeanUtils.populate(users, request.getParameterMap());
				users.setAdmin(false);
				dao.createUser(users);
				request.setAttribute("message", "Đăng kí thành công");
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("message", "Lỗi");
		}
	}

	protected void doimk(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		Users username = (Users) request.getSession().getAttribute("username");
		if (username == null) {
			request.getRequestDispatcher("/views/login/dangnhap.jsp").forward(request, response);
			return;
		} else {
			try {
				ChangePassword form = new ChangePassword();
				if (uri.contains("doi")) {
					String iduser = username.getId();
					BeanUtils.populate(form, request.getParameterMap());
					request.setAttribute("username", iduser);
					if (!form.getNewpass().equals(form.getComfirmpass())) {
						request.setAttribute("message", "Lỗi");
					} else {
						UserDao dao = new UserDao();
						dao.changePassword(form.getUsername(), form.getPassword(), form.getComfirmpass());
						request.setAttribute("message", "Thành công");
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	protected void thaydoitt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		Users username = (Users) request.getSession().getAttribute("username");

		if (username == null) {
			request.getRequestDispatcher("/views/login/dangnhap.jsp").forward(request, response);
			return;
		}
		try {
			String iduser = username.getId();
			UserDao dao = new UserDao();
			Users users = dao.findUserById(iduser);
			request.setAttribute("users", users);
			if (uri.contains("updatett")) {
				BeanUtils.populate(users, request.getParameterMap());
				dao.updateUser(users);
				request.setAttribute("message", "Cập nhật thành công");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
