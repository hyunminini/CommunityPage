package comment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/comment.do")
public class CommentController extends HttpServlet {
	protected void comments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		// 댓글 작성
		HttpSession sessionid = request.getSession();
		// 해당 페이지 board_cnum 가져오기
		int board_cnum = Integer.parseInt(request.getParameter("board_cnum"));
		// session 으로 ename 가져오기
		String ename = (String) sessionid.getAttribute("ename");
		String co_content = (String) sessionid.getAttribute("co_content");
		System.out.println("comments" + ename);
	try {
		CommentDAO.commentInsert(new CommentDTO(board_cnum, ename, co_content));
		// 저장 => BoardControll 이동
		
		request.getRequestDispatcher("board.do?command=read&board_cnum=" + board_cnum).forward(request, response);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	

}
