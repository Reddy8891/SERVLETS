package week7.jsf.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="bill")
@SessionScoped
public class ElectricityBill {
	private String meterId;
	private String crntMtrRd;
	private String prevMtrRd;
	private String zone;
	
	
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public String getCrntMtrRd() {
		return crntMtrRd;
		
	}
	public void setCrntMtrRd(String crntMtrRd) {
		this.crntMtrRd = crntMtrRd;
	}
	public String getPrevMtrRd() {
		return prevMtrRd;
	}
	public void setPrevMtrRd(String prevMtrRd) {
		this.prevMtrRd = prevMtrRd;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	

	private static final List<Electric> eleList = new ArrayList<>();
	public List<Electric> getStudents(){
		
		if(eleList.size() == 0) {
			
		
	    Connection con = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			 
		        //Scanner sc = new Scanner(System.in);
		        String url = "jdbc:mysql://localhost:3306/reddy";
		        String user = "root";
		        String pass = "root@123";
		        con = DriverManager.getConnection(url,user,pass);
		        if(con!=null) {
		        	System.out.println("success");
		        }
		        else {
		        	System.out.println("not success");
		        }
		        
		        try {
					
					PreparedStatement statement=null;
					String sql = "insert into ElectricityBill values (?, ?, ?,?)";
					statement = con.prepareStatement(sql);
					
					statement.setString(1, getMeterId());
					
					statement.setString(2, getCrntMtrRd());
					statement.setString(3, getPrevMtrRd());
					statement.setString(4, getZone());
					
					statement.execute();
				}catch (Exception ex) {
					ex.printStackTrace();
				}
				
  
		        
		        
		        
		        Statement stmt = con.createStatement();
		        ResultSet rs =  stmt.executeQuery("select * from ElectricityBill");
		        while(rs.next()) {
		        	String meterId1=rs.getString(1);
		        	 String crntMtrRd2=rs.getString(3);
		        	 String prevMtrRd3=rs.getString(4);
		        	
		        	System.out.println("hello"+rs.getString(1));
		        	System.out.println(getCrntMtrRd());
		        	eleList.add(new Electric(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		        	
		        	if( meterId1.equals(getMeterId())) {
		        		 int units=getCrntMtrRd()-getPrevMtrRd();
		        		 if(getZone().equals("uraban")) {
		        		 int amountPayable =units*4;}
		        		 else {
		        			 int amountPayable=units*6;
		        		 }
		        		
		        	}
		        	else {
		        		System.out.println("unsucessfull");
		        	}
		        }
		       
			 }  
		        catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			
			return eleList;
		}
		else {
			return eleList;
		}
		}
		
	
}
