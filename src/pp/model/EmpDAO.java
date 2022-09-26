package pp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtill;

public class EmpDAO {
	
		// 모든 게시물 조회
	public  static ArrayList<EmpDTO> getAllContents() throws SQLException{
		Connection con = null;	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<EmpDTO> alist = null;
		String sql="";	
		try {
			con = DBUtill.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			alist = new ArrayList<EmpDTO>();
			while(rset.next()){
				alist.add(new EmpDTO(rset.getInt(1),rset.getInt(2),
						rset.getString(3),rset.getString(4),rset.getString(5)
		 				,rset.getInt(6)));
			}
		}finally{
			DBUtill.close(rset, pstmt, con);
		}
		return alist;
	}
}
