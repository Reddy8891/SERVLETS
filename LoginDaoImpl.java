package com.training.web.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.training.web.model.User;

public class LoginDaoImpl implements LoginDao {
	public List<User> getUsers() {
		
		 List<User> userList = new ArrayList<>();
		 Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 
	        //Scanner sc = new Scanner(System.in);
	        String url = "jdbc:mysql://localhost:3306/infinite";
	        String user = "root";
	        String pass = "root@123";
	        conn = DriverManager.getConnection(url,user,pass);
	        Statement st = conn.createStatement();
	       User u = new User();
	       
        	PreparedStatement stmt =conn.prepareStatement("insert into product12 values(?,?)");

			 stmt.setInt(1, 123456);
			
			stmt.setString(2, u.getProddesc());
			
			stmt.executeUpdate();





// TODO Auto-generated catch block

//e.printStackTrace();
//
//}
	        
	        ResultSet rs = st.executeQuery("select * from product12");
	        
	        while(rs.next()) {
	          	userList.add(new User(rs.getString(2), rs.getString(3)));
	        	//userList.add(new User("oppo","ele"));
	        	
	        }
	       
		 }  
	        catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return userList;
	}
}
