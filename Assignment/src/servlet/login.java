package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import common.CookieUtils;
import common.SessionUtils;
import dao.UserDao;
import models.LoginForm;
import models.Users;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);

		if (session != null) {
			CookieUtils.get("username", request);
			request.getRequestDispatcher("/views/nguoidung/nguoidung.jsp").forward(request, response);
//			request.getRequestDispatcher("/views/login/home.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/views/login/dangnhap.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			LoginForm form = new LoginForm();
			BeanUtils.populate(form, request.getParameterMap());
			UserDao dao = new UserDao();
			Users user = dao.findUserById(form.getUsername());
			if (user != null && user.getPassword().equals(form.getPassword())) {
				request.getSession().setAttribute("username", user);
				request.getRequestDispatcher("/views/nguoidung/nguoidung.jsp").forward(request, response);
				if (form.isRemember()) {
					CookieUtils.add("username", form.getUsername(), 24, response);
				} else {
					CookieUtils.add("username", form.getUsername(), 0, response);
				}
					
//					request.getRequestDispatcher("/views/login/home.jsp").forward(request, response);

			} else {
				request.setAttribute("message", "Thông tin tài khoản không chính xác!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/views/login/dangnhap.jsp").forward(request, response);
	}

}
