package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDAO {
	private Connection con;
	private ResultSet rset;

	public BbsDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC";
			String dbID = "scott";
			String dbPassword = "tiger";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getDate() {
		String SQL = "SELECT NOW()";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				return rset.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ""; // 데이터베이스 오류
	}
	
	public int getNext() {
		String SQL = "SELECT bbsID FROM bbs ORDER BY bbsID DESC";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				return rset.getInt(1) + 1;
			}
			return 1; // 첫 번째 게시물인 경우
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
	public int write(String bbsTitle, String userID, String bbsContent) {
		String SQL = "INSERT INTO bbs VALUES(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, userID);
			pstmt.setString(4, getDate());
			pstmt.setString(5, bbsContent);
			pstmt.setInt(6, 1);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
	public ArrayList<Bbs> getList(int pageNumber) {
		String SQL = "SELECT * FROM bbs WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10";
		ArrayList<Bbs> list = new ArrayList<Bbs>();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsID(rset.getInt(1));
				bbs.setBbsTitle(rset.getString(2));
				bbs.setUserID(rset.getString(3));
				bbs.setBbsDate(rset.getString(4));
				bbs.setBbsContent(rset.getString(5));
				bbs.setBbsAvailable(rset.getInt(6));
				list.add(bbs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean nextPage(int pageNumber) {
		String SQL = "SELECT * FROM bbs WHERE bbsID < ? AND bbsAvailable = 1";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Bbs getBbs(int bbsID){
		String SQL = "SELECT * FROM BBS WHERE bbsID = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsID(rset.getInt(1));
				bbs.setBbsTitle(rset.getString(2));
				bbs.setUserID(rset.getString(3));
				bbs.setBbsDate(rset.getString(4));
				bbs.setBbsContent(rset.getString(5));
				bbs.setBbsAvailable(rset.getInt(6));
				return bbs;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int update(int bbsID, String bbsTItle, String bbsContent) {
		String SQL = "UPDATE BBS SET bbsTitle=?, bbsContent=? WHERE bbsID=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, bbsTItle);
			pstmt.setString(2, bbsContent);
			pstmt.setInt(3, bbsID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터 베이스 오류
	}
	
	public int delete(int bbsID) {
		String SQL = "UPDATE BBS SET bbsAvailable = 0 WHERE bbsID = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터 베이스 오류
	}
	
}
