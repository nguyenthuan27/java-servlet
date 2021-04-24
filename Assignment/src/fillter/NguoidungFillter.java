package fillter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Users;

/**
 * Servlet Filter implementation class NguoidungFillter
 */
@WebFilter(urlPatterns = { "/nguoidung/*" })
public class NguoidungFillter extends HttpFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		String uri = request.getRequestURI();
		Users username = (Users) request.getSession().getAttribute("username");
//		if (uri.contains("danhsach")) {
//			chain.doFilter(request, response);
//		} else if (uri.contains("like") || uri.contains("share")) {
//			if (username != null) {
//				chain.doFilter(request, response);
//			} else {
//				request.getRequestDispatcher("/views/login/dangnhap.jsp").forward(request, response);
//			}
//		}
		if (uri.contains("like") || uri.contains("share")) {
			if (username != null) {
				chain.doFilter(request, response);
			} else {
				request.getRequestDispatcher("/views/login/dangnhap.jsp").forward(request, response);
			}
		}else {
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
