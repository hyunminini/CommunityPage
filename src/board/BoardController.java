package board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import comment.CommentDAO;
import comment.CommentDTO;


// boardcon
@WebServlet("/board.do")
public class BoardController extends HttpServlet {
	
	String strNum= "";
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command"); 
		System.out.println("command " + command);
		System.out.println("체크합니다");
		
		
		
		if(command == null){
			command = "main";
		}
		
		if(command.equals("main")){
			try {
				Main(request, response);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
		}else if(command.equals("write")){
			write(request, response);
		}else if(command.equals("read")){
			read(request, response);
		}else if(command.equals("delete")){
				delete(request, response);
		}else if(command.equals("updateForm")){
			updateForm(request, response);
		}else if(command.equals("update")){
			update(request, response);
		}else if(command.equals("comment")) {
			comment(request, response);
		}
	}
	
	private void comment(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String ename=request.getParameter("ename");
		String co_content=request.getParameter("co_content");	
		String co_write_date=request.getParameter("co_write_date");
		Integer empno= Integer.parseInt(request.getParameter("empno"));
		Integer board_cnum= Integer.parseInt(request.getParameter("board_cnum"));
		
		int vpage = 0;
		if(request.getParameter("vpage") == null) {
			vpage = 1;
		}else {
			vpage = Integer.parseInt(request.getParameter("vpage"));
		}
		
		int total;
		try {
			total = BoardDAO.nextNum();
			int lastpage = (int)Math.ceil((double)total/10);
			
			request.setAttribute("empno", empno);
			
			boolean result = false ;	
			
			if(ename == null || ename.trim().length() == 0 ||
					co_content == null || co_content.trim().length() == 0)	{
				response.sendRedirect("board.do?command=read&board_cnum="+strNum);
				return;
			}
			
			CommentDTO newComment = null;
			try {
				newComment = new CommentDTO(board_cnum, ename, co_content, empno);
				
				result = CommentDAO.commentInsert(newComment);
				request.setAttribute("read", BoardDAO.getAllContents(vpage));
				request.setAttribute("lastpage", lastpage);
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("error", "게시글 저장 시도 실패 재 시도 하세요");
			}
			
			if(result){
				response.sendRedirect("board.do?command=read&board_cnum="+board_cnum+"&empno="+empno);
			}else{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void backDrop(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		boolean back = true;
		int vpage = 0;
		if(request.getParameter("vpage") == null) {
			vpage = 1;
		}else {
			vpage = Integer.parseInt(request.getParameter("vpage"));
		}
		
		int total;
		try {
			total = BoardDAO.nextNum();
			int lastpage = (int)Math.ceil((double)total/10);
			try {
				if (back == true) {
					request.setAttribute("Main", BoardDAO.getAllContents(vpage));
					request.setAttribute("lastpage", lastpage);
				}
				request.getRequestDispatcher("main.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	

	private void write(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// write.html에서 입력된 값들을 가져온다.
		String title=request.getParameter("title");
		String content=request.getParameter("content");	
		String category=request.getParameter("category");
		Integer empno= Integer.parseInt(request.getParameter("empno"));
		
		request.setAttribute("empno", empno);
		
		int vpage = 0;
		if(request.getParameter("vpage") == null) {
			vpage = 1;
		}else {
			vpage = Integer.parseInt(request.getParameter("vpage"));
		}
		
		int total;
		try {
			total = BoardDAO.nextNum();
			int lastpage = (int)Math.ceil((double)total/10);
			boolean result = false ;
			
			if(title == null || title.trim().length() == 0 ||
					content == null || content.trim().length() == 0 ||
					category == null || category.trim().length() == 0)
				
			{
				response.sendRedirect("boardWrite.jsp?empno="+empno);
				return;//write() 메소드 종료
			}
			
			// BoardWrite.html의 form에서 넘어온 데이터들로 BoardDTO객체를 생성해
			// DAO에 넘겨준다!
			try {
				result = BoardDAO.writeContent(new BoardDTO(title, empno, category, content));
				request.setAttribute("Main", BoardDAO.getAllContents(vpage));
				request.setAttribute("lastpage", lastpage);
				request.setAttribute("admin_entity", BoardDAO.getAdminContents());
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("error", "게시글 저장 시도 실패 재 시도 하세요");
			}
			
			// DAO를 통해 반환되어온 result값이 true면, 글쓰기(insert)완료
			// Redirect를 통해 command값이 초기화(?)되어 
			// list 목록을 불러오는 기능을 수행할 수 있도록 함!!
			
			if(result){
				request.getRequestDispatcher("main.jsp").forward(request, response);
				
			}else{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//데이터값 입력 유무만 유효성 검증
		// database에서 해당 값들은 not null로 지정해주었기 때문에
		// 해당 값들이 null값이면 재입력할 수 있도록 write.html로 Redirect함
		
		// 입력이 완료되었는지에 대한 결과를 의미
	}
	
	private void Main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String url = "error.jsp";
		System.out.println("Main called :");
		int empno;
		
		int vpage = 0;
		if(request.getParameter("vpage") == null) {
			vpage = 1;
		}else {
			vpage = Integer.parseInt(request.getParameter("vpage"));
		}
		
		int total = BoardDAO.nextNum();
		int lastpage = (int)Math.ceil((double)total/10);
		
		HttpSession session = request.getSession();
		
		session.getAttribute("empno");

		empno = Integer.parseInt(String.valueOf(session.getAttribute("empno")));
		
		
		
		request.setAttribute("empno", empno);
		String pw = request.getParameter("pw");
		request.setAttribute("pw", pw);
		String chkAdmin = BoardDAO.isAdmin(empno).getAdmin_authority();
		System.out.println("isAdmin? :"+chkAdmin);
		
		switch(chkAdmin) {
		case "ADMIN":
			request.setAttribute("Main", BoardDAO.getAllContents4Admin(vpage));
			request.setAttribute("lastpage", lastpage);
			break;
		default:
			request.setAttribute("Main", BoardDAO.getAllContents(vpage));
			request.setAttribute("lastpage", lastpage);
			break;
		}
		
		try {
			// DAO에서 반환되어온 전체 데이터를 request 객체에 담아
			// Main.jsp에서 뿌려주는 것.
			
			request.setAttribute("admin_entity", BoardDAO.getAdminContents());
			url = "main.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "모두 보기 실패 재 실행 해 주세요");
		}	
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private void read(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String strNum=request.getParameter("board_cnum");
//		System.out.println("read strNum: " + strNum);
		if(strNum==null || strNum.length() == 0){
			response.sendRedirect("board.do");
			return;
		}
		
		String url = "error.jsp";
		BoardDTO gContent = null;
		ArrayList<CommentDTO> commentList = null;
		
		try {
			gContent = BoardDAO.getContent(Integer.parseInt(strNum), true);
			commentList = CommentDAO.getAllComment(Integer.parseInt(strNum));
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "게시글 읽기 실패");
		}
		
		if(gContent == null){
			request.setAttribute("error", "해당 게시글이 존재하지 않습니다");
		}else{
			request.setAttribute("resultContent", gContent);
			request.setAttribute("coms", commentList);
			url = "boardRead.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String strNum=request.getParameter("board_cnum");

		if(strNum == null || strNum.trim().length() == 0 ){
				response.sendRedirect("board.do");	
				return;
			}
		boolean result = false;
		try {
			result = BoardDAO.deleteContent(Integer.parseInt(strNum));
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "해당 게시글 삭제 실패했습니다. 재 시도 하셔요");
		}
		if(result){
			response.sendRedirect("board.do");			
			return;
		}else{
			request.setAttribute("error", "삭제하려는 게시글이 존재하지 않습니다");
		}
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	
	
	
	// 수정 클릭
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// write와 유사하게 수정된 데이터를 가져옴.
		String strNum = request.getParameter("board_cnum");
		String title=request.getParameter("title");
		String content=request.getParameter("content");	
		String category=request.getParameter("category");
		Integer empno= Integer.parseInt(request.getParameter("empno"));
		
		if( strNum == null || strNum.trim().length() == 0 ||
			title == null || title.trim().length() == 0 ||
			content == null || content.trim().length() == 0 ||
			category == null || category.trim().length() == 0
		);
		
		boolean result = false;
		BoardDTO gContent = null;
		
		try {
			// DAO에서 반환되어온 전체 데이터를 request 객체에 담아 Main.jsp에서 뿌려주는 것
			result = BoardDAO.updateContent(new BoardDTO(title, category, content, Integer.parseInt(strNum)));
			gContent = BoardDAO.getContent(Integer.parseInt(strNum), true);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "게시글 수정 실패");
		}
		if(result){
			response.sendRedirect("board.do?command=read&board_cnum=" +strNum);
			return; // update() 메소드 종료
		}
		request.setAttribute("error", "게시글 수정 실패");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	
	// 수정 form
	private void updateForm(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException{
		String strNum = request.getParameter("board_cnum");
//		System.out.println("수정 FORM strNum: " + strNum);
		
		if(strNum == null || strNum.trim().length() == 0) {
			response.sendRedirect("board.do");
			return;				
		}
		String url = "error.jsp";
		BoardDTO gContent = null;
		try {
			gContent = BoardDAO.getContent(Integer.parseInt(strNum), false);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "수정하고자 하는 게시글 검색 실패했습니다");
		}
		if(gContent == null){
			request.setAttribute("error", "수정하고자 하는 게시글이 존재하지 않습니다");
		}else{
			request.setAttribute("resultContent", gContent);
			url = "update.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	
	

}
