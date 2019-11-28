package v3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DB_Control {

	private Connection conn;
	//private PreparedStatement pstmt;
	private ResultSet rs;

	public DB_Control() {
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
	
	public ArrayList<Node> getList(ArrayList<Node> list) {
		String SQL = "SELECT * FROM WORKERS";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Node node = new Node();
				node.setUserID(rs.getString(1));
				node.setUserIP(rs.getString(2));
				node.setCpuUse(rs.getString(3));
				node.setCpuCapa(rs.getString(4));
				node.setMemUse(rs.getString(5));
				node.setMemCapa(rs.getString(6));
				node.setState(rs.getString(7));				
				list.add(node);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public int delete(String userIP) {
		String SQL = "DELETE FROM WORKERS WHERE userIP=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userIP);
			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터 베이스오류

	}
	
	
	public int insert(String userID, String userIP, String CpuUse, String CpuCapa, String MemUse, String MemCapa, String State) {
		String SQL = "INSERT INTO WORKERS VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setString(2, userIP);
			pstmt.setString(3, CpuUse);
			pstmt.setString(4, CpuCapa);
			pstmt.setString(5, MemUse);
			pstmt.setString(6, MemCapa);
			pstmt.setString(7, State);
			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터 베이스오류
	}
	
	public int use_update(String userIP, String CpuUse, String MemUse) {
		String SQL = "UPDATE WORKERS SET CpuUse = ?, MemUse = ? WHERE userIP = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, CpuUse);
			pstmt.setString(2, MemUse);
			pstmt.setString(3, userIP);			
			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터 베이스오류		
	}
	
	public int find(String userIP) {
		String SQL = "SELECT * FROM WORKERS WHERE userIP = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userIP);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int write(Node node) {
		if(find(node.getUserIP())== 1) {
			System.out.println("있어!");
			use_update(node.getUserIP(), node.CpuUse, node.MemUse);
			return 1;
		}
		insert(node.getUserID(), node.getUserIP(), node.getCpuUse(), node.getCpuCapa(), node.getMemUse(), node.getMemCapa(), node.getState());
		System.out.println("없어");
		return -1;
	}
}
