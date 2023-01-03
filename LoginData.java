package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class LoginData
 */
@WebServlet("/LoginData")
public class LoginData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String mobNum = request.getParameter("number");
		PrintWriter out = response.getWriter();
		try {
			boolean flag=false;
			 
			 Connection con = DatabaseConnection.initializeDatabase();
			  
           Statement st = con.createStatement();
           
           ResultSet rs = st.executeQuery("select * from register");
	      
	        while(rs.next()) {	
	        	
	        	if(rs.getDouble(3)==Double.valueOf(request.getParameter("number")))
	        	{
	        		 flag = true;
	        		out.println("<h3>successfully logged in</h3>");
	        		break;
	        	}
	        }
	        	if(flag==false) {
	        	
	        		out.println("<h3>incorrect credentials to login</h3>");
	     
	        	}
	        
		}
		catch (Exception e) 
		{
	            e.printStackTrace();
		}	           
//	            PrintWriter out = response.getWriter();
//	            out.println("<html><body><b><h1>Successfully Deleted Product</h1>"
//	            		
//	                        + "</b></body></html>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
