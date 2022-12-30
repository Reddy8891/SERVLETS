package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AboutServlet
 */
@WebServlet("/aboutServlet1")
public class AboutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 //ServletConfig config=getServletConfig();
    public AboutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init() throws ServletException {
   //this.config=config;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletConfig config=getServletConfig();
		ServletContext con=getServletConfig(). getServletContext();
		String pass=config.getInitParameter("password");
		//String passw="Reddy@1234";
		
		String value=con.getInitParameter("Name");
		
		String username=request.getParameter("name");
		String passwd=request.getParameter("passw");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>"+value+"</h1>");
		
		if(pass.equals(passwd)) {
		out.println("<h2>"+"welcome"+" "+username+"</h2>");
		}
		else
		{
			out.println("not matched");
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
