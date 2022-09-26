package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtill {
	
	static DataSource ds;

	// DBUt
	// 1단계 : Driver 로딩
	static {
		Context initContext = null;
		
		try {
			initContext = new InitialContext();
			
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			// Context.xml 의 Resource name
			ds = (DataSource)envContext.lookup("jdbc/mysql");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// 2단계 : DB 연결 가능 메소드
	public static Connection getConnection() throws SQLException {
			//  DriverManager.getConnection(~) 값을 ds에 저장하여 불러옴 
		return ds.getConnection();
	}
	
	// 6단계 : 자원반환 메소드
	public static void close(ResultSet rset, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rset != null) {
			rset.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(con != null) {
			con.close();
		}
	}
	
	public static void close(PreparedStatement pstmt, Connection con) throws SQLException {
		if(pstmt != null) {
			pstmt.close();
		}
		if(con != null) {
			con.close();
		}
	}

}
