
package servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import dao.FaveriseDao;
import dao.UserDao;
import dao.VideoDao;
import models.ListLikeVideo;
import models.Report;
import models.ShareList;
import models.Users;
import models.Videos;

/**
 * Servlet implementation class homeservlet
 */
@MultipartConfig
@WebServlet({ "/home/trangchu", "/home/qlvideo", "/home/qlusers", "/home/thongke", "/home/thongke/thongke1",
		"/home/thongke/thongke2", "/home/thongke/thongke3", "/home/thongke/select", "/home/qlusers/edit/*",
		"/home/qlusers/createUser", "/home/qlusers/updateUser", "/home/qlusers/deleteUser", "/home/qlvideo/edit/*",
		"/home/qlvideo/createVideo", "/home/qlvideo/updateVideo", "/home/qlvideo/deleteVideo", "/home/qlvideo/upload",
		"/home/qlvideo/reset" })

public class homeservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao dao = new UserDao();
	VideoDao vdao = new VideoDao();
	Users user = new Users();
	Videos video = new Videos();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public homeservlet() {
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
		if (uri.contains("trangchu")) {
			request.setAttribute("view", "/views/admin/trangchu.jsp");
		} else if (uri.contains("qlvideo")) {
			this.video(request, response);
			List<Videos> items = vdao.findAllVideo();
			request.setAttribute("items", items);
			request.setAttribute("form", video);
			request.setAttribute("view", "/views/admin/qlvideo.jsp");

		} else if (uri.contains("qlusers")) {
			this.user(request, response);
			List<Users> items = dao.findAllUser();
			request.setAttribute("items", items);
			request.setAttribute("form", user);
			request.setAttribute("view", "/views/admin/qlusers.jsp");
		} else if (uri.contains("thongke")) {
//			try {
//				FaveriseDao adao = new FaveriseDao();
//				List<Report> list = adao.getReport();
//				
//				
//				String videoids = request.getParameter("videoids");
//				List<Videos> vlist  = vdao.findAllVideo();
//				List<FavoriteUserVideo> listlike = adao.getUserLikeVideo(videoids); 
//				
//				request.setAttribute("vlist", vlist);
//				request.setAttribute("videoids", videoids);
//				request.setAttribute("listlike", listlike);
//				request.setAttribute("list", list);
//			} catch (Exception e) {
//				// TODO: handle exception
//				System.out.print("Lỗi");
//			e.printStackTrace();
//			}

			if (uri.contains("thongke1")) {
				try {
					FaveriseDao adao = new FaveriseDao();
					List<Report> list = adao.getReport();
					request.setAttribute("list", list);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.print("Lỗi");
					e.printStackTrace();

				}
				request.setAttribute("view1", "/views/thongke/thongke1.jsp");
			} else if (uri.contains("thongke2")) {
				try {
					FaveriseDao adao = new FaveriseDao();
					List<Videos> vlist = vdao.findAllVideo();
					List<ListLikeVideo> listlikevideo = adao.geLikeVideo();
					request.setAttribute("listlikevideo", listlikevideo);

					request.setAttribute("view1", "/views/thongke/thongke2.jsp");
				} catch (Exception e) {
					// TODO: handle exception
				}
			} else if (uri.contains("thongke3")) {
				System.out.println("sf");
				FaveriseDao adao = new FaveriseDao();
				List<ShareList> shalist = adao.getShare();
				request.setAttribute("shalist", shalist);
				request.setAttribute("view1", "/views/thongke/thongke3.jsp");
			} else {
				request.setAttribute("view1", "/views/thongke/thongke1.jsp");
			}
			request.setAttribute("view", "/views/thongke/baocao.jsp");
		}

		request.getRequestDispatcher("/views/login/home.jsp").forward(request, response);
	}

	protected void video(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("edit")) {
			String id = uri.substring(uri.lastIndexOf("/") + 1);
			video = vdao.findVideoById(id);
			List<Videos> items = vdao.findAllVideo();
			request.setAttribute("items", items);
		} else if (uri.contains("createVideo")) {
			try {
				BeanUtils.populate(video, request.getParameterMap());
				Part part = request.getPart("poster");
				String realPath = request.getServletContext().getRealPath("/imgs");
				String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
				if (!Files.exists(Path.of(realPath))) {
					Files.createDirectories(Path.of(realPath));
				}
				part.write(realPath + "/" + filename);
				video.setPoster(filename);
				vdao.createVideo(video);
				List<Videos> items = vdao.findAllVideo();
				request.setAttribute("message", "Thêm mới thành công");

				request.setAttribute("items", items);

			} catch (Exception e) {
				// TODO: handle exception
				request.setAttribute("message", "Thêm mới thất bại");
			}
		} else if (uri.contains("updateVideo")) {
			try {
				Videos vi = new Videos();
				BeanUtils.populate(vi, request.getParameterMap());
				Part part = request.getPart("poster");
				String realPath = request.getServletContext().getRealPath("/imgs");
				String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
				if (!Files.exists(Path.of(realPath))) {
					Files.createDirectories(Path.of(realPath));
				}
				part.write(realPath + "/" + filename);
				vi.setPoster(filename);
				vdao.updateVideo(vi);
				List<Videos> items = vdao.findAllVideo();

				request.setAttribute("message", "Cập nhật thành công");
				request.setAttribute("items", items);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				request.setAttribute("message", "Cập nhật thất bại");
			}

		} else if (uri.contains("deleteVideo")) {
			try {
				String id = request.getParameter("id");
				vdao.deleteVideo(id);
				request.setAttribute("message", "Xóa thành công");
				List<Videos> items = vdao.findAllVideo();
				request.setAttribute("items", items);
			} catch (Exception e) {
				// TODO: handle exception
				request.setAttribute("message", "Xóa thất bại");
			}
		} else {
			List<Videos> items = vdao.findAllVideo();
			request.setAttribute("items", items);
		}
	}

	protected void user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("qlusers/edit")) {
			String id = uri.substring(uri.lastIndexOf("/") + 1);
			user = dao.findUserById(id);
			List<Users> items = dao.findAllUser();
			request.setAttribute("items", items);
		} else if (uri.contains("updateUser")) {
			try {
				BeanUtils.populate(user, request.getParameterMap());
				dao.updateUser(user);
				request.setAttribute("message", "Cập nhật thành công");
				List<Users> items = dao.findAllUser();
				request.setAttribute("items", items);

			} catch (Exception e) {
				// TODO: handle exception
				request.setAttribute("message", "Cập nhật thất bại");
			}

		} else if (uri.contains("deleteUser")) {
			try {
				String id = request.getParameter("id");
				dao.deleteUser(id);
				request.setAttribute("message", "Xóa thành công");
				List<Users> items = dao.findAllUser();
				request.setAttribute("items", items);
			} catch (Exception e) {
				// TODO: handle exception
				request.setAttribute("message", "Xóa thất bại");
			}
		} else {
			List<Users> items = dao.findAllUser();
			request.setAttribute("items", items);
		}
		List<Users> items = dao.findAllUser();
		request.setAttribute("items", items);
		request.setAttribute("form", user);
	}

//	protected void thongke(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String uri = request.getRequestURI();
//		if (uri.contains("thongke")) {
//			FaveriseDao fdao =new FaveriseDao();
//			List<Report> rip = fdao.getReportVideo();
//			System.out.print("kkk"+rip.get(0).getGrounp());
//			request.setAttribute("rip", rip);
//		}
//	}
}
