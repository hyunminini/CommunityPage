package comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board.BoardDTO;
import util.DBUtil;

public class CommentDAO {

	// 모든 댓글 조회
	public static ArrayList<CommentDTO> getAllComment(int board_cnum) throws SQLException{
		Connection con = null;	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CommentDTO> clist = null;
		String query="SELECT * from COMMENT AS c, EMP AS e where C.EMPNO = E.EMPNO AND BOARD_CNUM = ?;";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, board_cnum);
			rset = pstmt.executeQuery();
			clist = new ArrayList<CommentDTO>();
			while(rset.next()){
				clist.add(new CommentDTO(rset.getInt(1),
										 rset.getString(10),
										 rset.getInt(3),
										 rset.getString(4),
										 rset.getString(5)));
			}
			
		}finally{
			DBUtil.close(rset, pstmt, con);
		}
		return clist;
	}
	
	// 댓글 작성
	public static boolean commentInsert(CommentDTO vo) throws SQLException {
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		System.out.println("1" + result);
		System.out.println("commentDAO" + vo);
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into comment(EMPNO, BOARD_CNUM, CO_CONTENT) values (?, ?, ?);");
			pstmt.setInt(1, vo.getEmpno());
			pstmt.setInt(2, vo.getBoard_cnum());
			pstmt.setString(3, vo.getCo_content());
			
			int count = pstmt.executeUpdate();
			if(count != 0) {
				result = true;
				System.out.println("실행" + result);
			}
			
		} finally {
			DBUtil.close(con,  pstmt);
			System.out.println("파이널" + result);
		}
		return result;
	}
	
}
