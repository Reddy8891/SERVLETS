package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import com.training.web.service.LoginService;
import com.training.web.service.LoginServiceImpl;

/**
 * Servlet Filter implementation class Login03
 */
@WebFilter("/WelcomServlet1")
public class Login03 extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public Login03() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		LoginService service = new LoginServiceImpl();
		//String uId = request.getParameter("uid");
		String mobNum = request.getParameter("number");
		
		//if(uId.equals("") || mobNum.equals("")) {
		if(mobNum.equals("")) {
			out.println("give correct num");
			
			RequestDispatcher rd= request.getRequestDispatcher("Login1.jsp");
			rd.include(request, response);
		}
		else if( mobNum.equals("123")){
		//else if(service.isValidUser( mobNum)) {
			out.println("successfully registered");
			
			//request.setAttribute("userId", uId);
			request.setAttribute("mobilenum", mobNum);
			
			}
		else {
			out.println("incorrect");
			RequestDispatcher rd= request.getRequestDispatcher("registration.jsp");
			rd.include(request, response);
			
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
