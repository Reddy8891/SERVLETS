package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import com.training.web.model.User;
import com.training.web.service.LoginService;
import com.training.web.service.LoginServiceImpl;
/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/WelcomServlet1")
public class LoginFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
	
    public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	//@SuppressWarnings("unused")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        String url="jdbc:mysql://localhost:3306/infinite";
	        String user="root";
	        String password="root@123";
	        Connection con=DriverManager.getConnection(url,user,password);
	        if(con!=null){
	            System.out.println("connection successfull");

	        }
	        else{
	            System.out.println("connection unsuccess");
	        }

		}
		catch(Exception e){
			e.printStackTrace();		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String prodName = request.getParameter("prod_name");
		String proddesc = request.getParameter("prod_desc");
		
		LoginService service = new LoginServiceImpl();
				
		if(prodName.equals("") || proddesc.equals("")) {
			out.print("<h2>**Please enter product name and product desc**<h2>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
//		else if(prodName.equals("oppo")&& proddesc.equals("123")) {
//			RequestDispatcher rd = request.getRequestDispatcher("/WelcomServlet1");
//			rd.forward(request, response);
		else if(service.isValidUser(prodName, proddesc)) {
			List<User> userList = service.getUsers();
			request.setAttribute("user", prodName);
			request.setAttribute("password", proddesc);
			request.setAttribute("userList", userList);
			chain.doFilter(request, response);
		}
	
		else {
			out.print("<h2>Incorrect login credential!!<h2>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
		
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
