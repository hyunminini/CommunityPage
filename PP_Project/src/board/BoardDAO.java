package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;

public class BoardDAO {
	
	// 게시물 등록
	public static boolean writeContent(BoardDTO vo) throws SQLException{
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		String query ="insert into board(TITLE, EMPNO,CONTENT, CATEGORY) value(?,?,?,?)";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getEmpno()); 
	        pstmt.setString(3, vo.getContent());
	        pstmt.setString(4, vo.getCategory());
	        
			int count = pstmt.executeUpdate();			
			if(count != 0){
				result = true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		
		return result;		
	}
	
	// 모든 게시물 조회
	public static ArrayList<BoardDTO> getAllContents() throws SQLException{
		Connection con = null;	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BoardDTO> alist = null;
		String query="select BOARD_CNUM, B.CATEGORY, B.TITLE, E.EMPNO, E.ENAME, B.WRITE_DATE, B.READNUM from BOARD B, EMP E WHERE E.EMPNO = B.EMPNO ORDER BY BOARD_CNUM DESC;";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			alist = new ArrayList<BoardDTO>();
			while(rset.next()){
				alist.add(new BoardDTO(rset.getInt(1),rset.getString(2),
						rset.getString(3),rset.getInt(4), rset.getString(5),rset.getString(6)
		 				,rset.getInt(7)));
			}
			
		}finally{
			DBUtil.close(rset, pstmt, con);
		}
		return alist;
	}
	
	// 게시물 읽기 - boolean flag 값 = read인 경우 true, update인 경우  false
			public static BoardDTO getContent(int board_cnum, boolean flag) throws SQLException{		

			Connection con = null;	
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			BoardDTO vo  = null;
			String query1="update BOARD set READNUM = READNUM+1 where BOARD_CNUM = ?";
			String query2="select B.BOARD_CNUM, B.TITLE, B.WRITE_DATE, B.CATEGORY, E.ENAME, B.READNUM, B.CONTENT from BOARD B, EMP E where B.empno = E.empno and board_cnum = ?";
			
			try {
				con = DBUtil.getConnection();
				if(flag){
					pstmt = con.prepareStatement(query1);
					pstmt.setInt(1, board_cnum);
					int count = pstmt.executeUpdate();
					if(count == 0){
						return vo;
					}
				}
				
				pstmt = con.prepareStatement(query2);
				pstmt.setInt(1, board_cnum);	
				rset = pstmt.executeQuery();
				
				if(rset.next()){
					vo = new BoardDTO(board_cnum, rset.getString("TITLE"),
							rset.getString("WRITE_DATE"), rset.getString("CATEGORY"), rset.getString("ENAME"),
							rset.getInt("READNUM"), rset.getString("CONTENT")
							);
					vo.setBoard_cnum(board_cnum);
				}
			}finally{
				DBUtil.close(rset, pstmt, con);
			}
			return vo;
		}
		
		//게시물 삭제
		public  static boolean deleteContent(int board_cnum, int empno) throws SQLException{
			Connection con = null;	
			PreparedStatement pstmt = null;
			boolean result = false;
			
			String query = "DELETE FROM a USING BOARD as a LEFT JOIN EMP AS b ON a.EMPNO = b.EMPNO where b.EMPNO = ?";
			
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(query);

				pstmt.setInt(1, board_cnum);
		        pstmt.setInt(2, empno);

				int count = pstmt.executeUpdate();
				
				if(count != 0){
					result = true;
				}
			}finally{
				DBUtil.close(con, pstmt);
			}
			return result;
		}
		
		// 게시물 수정
		public static boolean updateContent(BoardDTO vo) throws SQLException{
			Connection con = null;	
			PreparedStatement pstmt = null;
			boolean result = false;
			String query = "update board set TITLE = ?, CONTENT = ?, CATEGORY = ? where board_cnum = ?";
			
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, vo.getTitle()); 
		        pstmt.setString(2, vo.getContent());
		        pstmt.setString(3, vo.getCategory());
		        pstmt.setInt(4, vo.getBoard_cnum());
		        
				int count = pstmt.executeUpdate();
				
				if(count != 0){
					result = true;
				}	
			}finally{
				DBUtil.close(con, pstmt);
			}
			return result;
		}
		
		//좋아요 업데이트	
//		int like_count;
//		public void update_Like(int bno){		
//			String query = "update LIKE_TBL set LIKE_COUNT = LIKE_COUNT+1 where EMPNO = EMPNO AND BOARD_CNUM = ?";	
//			System.out.println(query);
//			Connection conn = null;		
//			PreparedStatement pstmt = null;			
//			try{ conn = DBUtil.getConnection();		
//				pstmt = conn.prepareStatement(query); 				
//				pstmt.setInt(1,bno);
//				pstmt.setInt(2, like_count);
//				pstmt.executeUpdate();		
//			}catch(SQLException e){			
//				e.printStackTrace();		
//				}finally {			
//					DBUtil.close(conn, pstmt);		
//				}		
//			}
		
		//좋아요 개수 찾기	
//		public int select_Like(int board_cnum){		
//			String query = "select LIKE_COUNT from LIKE_TBL";
//			Connection conn = null;	
//			PreparedStatement pstmt = null;	
//			ResultSet rset = null;		
//			int like=0;		
//			try{ conn = DBUtil.getConnection();	
//				 pstmt = conn.prepareStatement(query);  // '?'바인드를 사용해서 sql문을 효과 적으로 사용할수있음
//			  	 pstmt.setInt(1,board_cnum);			
//			  	 rset = pstmt.executeQuery();					
//			  	 if(rset.next()){				
//			  		 like = rset.getInt("like_count");		
//			  	 }}catch(SQLException e){	
//			  		 e.printStackTrace();		
//			  	   }finally {			
//			  		   DBUtil.close(rset, pstmt, conn);		
//			  	   }		
//			return like;	
//		}
//		
		
}
