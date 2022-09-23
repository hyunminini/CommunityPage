package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// connectionPool 변경..

public class DBUtill {
	
	static DataSource ds; //추가 
	
	static {  // 추가
		Context initContext = null;
		
		try {
			initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/mysql");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	// 6단계 : 자원반환 메소드
	public static void close(ResultSet rset, Statement stmt, Connection con) throws SQLException {
		if(rset != null) {
			rset.close();
		}
		if(stmt != null) {
			stmt.close();
		}
		if(con != null) {
			con.close();
		}
	}
	
	public static void close(Statement stmt, Connection con) throws SQLException {
		if(stmt != null) {
			stmt.close();
		}
		if(con != null) {
			con.close();
		}
	}
}
