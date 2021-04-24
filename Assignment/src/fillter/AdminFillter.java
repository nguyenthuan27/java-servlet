package fillter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Users;


/**
 * Servlet Filter implementation class AdminFillter
 */
@WebFilter(urlPatterns = {"/home/*"})
public class AdminFillter extends HttpFilter {

   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here	
		String uri = request.getRequestURI();
         Users username = (Users)request.getSession().getAttribute("username"); 
         if(uri.contains("trangchu")) {
        	 chain.doFilter(request, response);
         }else {
        	 if (username!=null) {		
            	 chain.doFilter(request, response);
            	 request.getRequestDispatcher("/views/login/home.jsp").forward(request, response);
             }else {
            	 
            	 request.getRequestDispatcher("/views/login/dangnhap.jsp").forward(request, response);
             }
         }


	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
