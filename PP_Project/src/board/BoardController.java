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

import com.mysql.cj.Session;

import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import board.BoardDAO;
import board.BoardDTO;

// boardcon
@WebServlet("/board.do")
public class BoardController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		HttpSession sesstion = request.getSession();
		
		Integer empno = (Integer) sesstion.getAttribute("empno"); 
		System.out.println("command " + command);
		
		if(command == null){
			command = "main";
		}		
		
		if(command.equals("main")){
			Main(request, response);
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
		}
	}

	private void write(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// write.html에서 입력된 값들을 가져온다.
		String title=request.getParameter("title");
		String content=request.getParameter("content");	
		String category=request.getParameter("category");
		Integer empno= Integer.parseInt(request.getParameter("empno"));
<<<<<<< HEAD
//		String pw=request.getParameter("pw");
=======
>>>>>>> e5dbe3fdb7ee1f8edd5dfe3317c63d264ea4d00a
		
//		System.out.println("writempno:"+empno);
		
		request.setAttribute("empno", empno);
<<<<<<< HEAD
//		request.setAttribute("pw", pw);
=======
>>>>>>> e5dbe3fdb7ee1f8edd5dfe3317c63d264ea4d00a
		
		//데이터값 입력 유무만 유효성 검증
		// database에서 해당 값들은 not null로 지저해주었기 때문에
		// 해당 값들이 null값이면 재입력할 수 있도록 write.html로 Redirect함
		
		// 입력이 완료되었는지에 대한 결과를 의미
		boolean result = false ;
		
		if(title == null || title.trim().length() == 0 ||
		content == null || content.trim().length() == 0 ||
		category == null || category.trim().length() == 0)
//		empno == null || empno.trimToSize() == 0 
//		pw == null || pw.trim().length() == 0 )
<<<<<<< HEAD
		{
			
=======
		
		{
>>>>>>> e5dbe3fdb7ee1f8edd5dfe3317c63d264ea4d00a
			response.sendRedirect("BoardWrite.jsp?empno="+empno);
			return;//write() 메소드 종료
		}
		
		
		// BoardWrite.html의 form에서 넘어온 데이터들로 BoardDTO객체를 생성해
		// DAO에 넘겨준다!
		try {
			result = BoardDAO.writeContent(new BoardDTO(title, empno, category, content));
<<<<<<< HEAD
=======
			request.setAttribute("Main", BoardDAO.getAllContents());
>>>>>>> e5dbe3fdb7ee1f8edd5dfe3317c63d264ea4d00a
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "게시글 저장 시도 실패 재 시도 하세요");
		}
		
		// DAO를 통해 반환되어온 result값이 true면, 글쓰기(insert)완료
		// Redirect를 통해 command값이 초기화(?)되어 
		// list 목록을 불러오는 기능을 수행할 수 있도록 함!!
<<<<<<< HEAD
		if(result){
			request.getRequestDispatcher("ppProject.do").forward(request, response);
=======
		
		if(result){
			request.getRequestDispatcher("empcon").forward(request, response);
>>>>>>> e5dbe3fdb7ee1f8edd5dfe3317c63d264ea4d00a
		}else{
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	
	private void Main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "error.jsp";
		
		int empno = Integer.parseInt(request.getParameter("empno"));
		request.setAttribute("empno", empno);
		
		String pw = request.getParameter("pw");
		request.setAttribute("pw", pw);
		
		try {
			// DAO에서 반환되어온 전체 데이터를 request 객체에 담아
			// Main.jsp에서 뿌려주는 것.
			request.setAttribute("Main", BoardDAO.getAllContents());
			url = "main.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "모두 보기 실패 재 실행 해 주세요");
		}	
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private void read(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String strNum=request.getParameter("board_cnum");
		System.out.println("read strNum: " + strNum);
		if(strNum==null || strNum.length() == 0){
			response.sendRedirect("board.do");
			return;
		}
		String url = "error.jsp";
		BoardDTO gContent = null;
		try {
			gContent = BoardDAO.getContent(Integer.parseInt(strNum), true);
			
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "게시글 읽기 실패");
		}
		
		if(gContent == null){
			request.setAttribute("error", "해당 게시글이 존재하지 않습니다");
		}else{
			request.setAttribute("resultContent", gContent);
			url = "BoardRead.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String strNum=request.getParameter("board_cnum");
		String empno = request.getParameter("empno");
		
		if(strNum == null || strNum.trim().length() == 0 ||
			empno == null || empno.trim().length() == 0){
			response.sendRedirect("board.do");
			return;				
		}
		boolean result = false;
		try {
			result = BoardDAO.deleteContent(Integer.parseInt(strNum), Integer.parseInt(empno));
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
		
		System.out.println("Update strNum: " + strNum);
		System.out.println("Update title: " + title);
		System.out.println("Update content: " + content);
		System.out.println("Update category: " + category);
		System.out.println("Update empno: " + empno);
		
		if(strNum == null || strNum.trim().length() == 0 ||
				title == null || title.trim().length() == 0 ||
				content == null || content.trim().length() == 0 ||
				category == null || category.trim().length() == 0
				);
		
		boolean result = false;
		
		try {
			// DAO에서 반환되어온 전체 데이터를 request 객체에 담아
			// Main.jsp에서 뿌려주는 것. error;;
			result = BoardDAO.updateContent(new BoardDTO(Integer.parseInt(strNum), title, empno, category, content));
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "게시글 수정 실패");
		}
		if(result){
			response.sendRedirect("board.do");
			return; // update() 메소드 종료
		}
		request.setAttribute("error", "게시글 수정 실패");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	
	// 수정 form
	private void updateForm(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException{
		String strNum = request.getParameter("board_cnum");
		System.out.println("수정 FORM strNum: " + strNum);
		
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
