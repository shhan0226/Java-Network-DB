package v2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

	private static Connection conn;
	public static void main(String[] args) {
	     
	        try {
	            
				String dbURL = "jdbc:mysql://210.94.185.156:3306/MJM?serverTimezone=UTC";
				String dbID ="mjmServer";
				String dbPassword ="pass";
				Class.forName("com.mysql.jdbc.Driver");				
				conn=DriverManager.getConnection(dbURL, dbID, dbPassword);
	    		PreparedStatement pstmt = null;
	    		ResultSet rs = null;            
	            String SQL;
	            SQL = "INSERT INTO WORKERS VALUES (?, ?, ?, ?, ?, ?, ?)";
	            
	            try {
	    			pstmt = conn.prepareStatement(SQL);
	    			pstmt.setString(1, "adsf");
	    			pstmt.setString(2, "201.0.0.0");
	    			pstmt.setString(3, "1");
	    			pstmt.setString(4, "2");
	    			pstmt.setString(5, "3");
	    			pstmt.setString(6, "4");
	    			pstmt.setString(7, "on");
	    			
	    			pstmt.executeUpdate();
					
				} catch (Exception e) {					
					e.printStackTrace();
				}	            
	        }catch(Exception e) {
	        	e.printStackTrace();
	        	
	        }

	}

}
