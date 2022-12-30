package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.web.model.User;

/**
 * Servlet implementation class WelcomServlet1
 */
@WebServlet("/WelcomServlet1")
public class WelcomServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user = (String)request.getAttribute("user");
		out.println(user);
		out.println("hello");
		List<User> usrList = (List<User>)request.getAttribute("userList");
		out.print("<h1>Welcome "+user+"! You are successfully logged in </h1>");
		
		out.println("<table border='1'> ");
		out.println("<tr> <th>");
		out.println("prodName </th>");
		out.println("<th> proddesc </th>");
		
		
		for(User usr:usrList) {
			out.println("<tr><td>" +usr.getProdName() +"</td>");
			out.println("<td>" +usr.getProddesc() +"</td> </tr>");
			
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
