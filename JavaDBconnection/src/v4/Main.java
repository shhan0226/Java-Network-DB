package v4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
	private static Connection conn;
	private static ResultSet rs;
	static String userID = "Han";
		
	public static void main(String[] args) {
		try {
			String dbURL = "jdbc:mysql://210.94.185.156:3306/MJM?serverTimezone=UTC";
			String dbID = "mjmServer";
			String dbPassword = "pass";
			//Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String SQL = "INSERT INTO IMGS VALUES (?, ?)";		
		try {
			File file = new File("img\\1.jpg");
			int fileLength = (int)file.length();
			InputStream is = new FileInputStream(file);		

			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setBinaryStream(2, is, fileLength);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		output();
	}
	
	public static void output() {
		String SQL = "SELECT * FROM IMGS";
		String sql ="img\\2.jpg";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString(1));
                InputStream is = rs.getBinaryStream(2);                
                FileOutputStream fos = new FileOutputStream(sql);
                byte[] buff = new byte[8192];
                int len;
                while( (len = is.read(buff)) > 0){
                    fos.write(buff, 0, len);
                }
                fos.close();
                is.close();
                rs.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
