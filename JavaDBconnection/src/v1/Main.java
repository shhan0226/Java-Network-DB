package v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {

		 Connection connection = null;
	        Statement st = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection("jdbc:mysql://210.94.185.156:3306/MJM?serverTimezone=UTC" , "mjmServer", "pass");
	            st = connection.createStatement();
	 
	            String sql;
	            sql = "select * FROM workers;";
	 
	            ResultSet rs = st.executeQuery(sql);
	            //ResultSet rs = st.executeQuery("SHOW DATABASES");
	 
	            
	            while (rs.next()) {
	                //String sqlRecipeProcess = rs.getString();
	            	String str = rs.getNString(1);
	            	str = rs.getNString(2);
	            	str = rs.getNString(3);
	            	str = rs.getNString(4);
	            	str = rs.getNString(5);
	            	str = rs.getNString(6);
	            	str = rs.getNString(7);
					System.out.println(str);
	
	            }
         
	            rs.close();
	            st.close();
	            connection.close();
	        } catch (SQLException se1) {
	            se1.printStackTrace();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (st != null)
	                    st.close();
	            } catch (SQLException se2) {
	            }
	            try {
	                if (connection != null)
	                    connection.close();
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        } 

	}

}
