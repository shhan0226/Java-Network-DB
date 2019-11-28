package v4;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JobDB_Control {
	
	
	private Connection conn;
	private ResultSet rs;

	public JobDB_Control() {
		try {
			String dbURL = "jdbc:mysql://210.94.185.156:3306/MJM?serverTimezone=UTC";
			String dbID = "mjmServer";
			String dbPassword = "pass";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public int insert(String userID, Object Img) {
		/*String SQL = "INSERT INTO IMGS VALUES (?, ?)";
		try {
			File file = new File(fileName);			
			InputStream is = new FileInputStream(file);			
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setBinaryStream(2, is, Img);
	
			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
*/		return -1; // 데이터 베이스오류
	}
	
		
}
