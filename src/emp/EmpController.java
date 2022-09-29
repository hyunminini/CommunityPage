package emp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardDAO;

@WebServlet("/emp.do")
public class EmpController extends HttpServlet {
	
    public EmpController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{	
		
		Integer empno = Integer.parseInt(request.getParameter("empno"));
		System.out.println("emp.do"+empno);
		
		
		try {
			empno = Integer.parseInt(request.getParameter("empno"));		
			
			int vpage = 0;
			int total = BoardDAO.nextNum();
			int lastpage = (int)Math.ceil((double)total/10);

			request.setAttribute("lastpage", lastpage);
			if(request.getParameter("vpage") == null) {
				vpage = 1;
			}
			if (empno !=null) {
				HttpSession session = request.getSession();
				session.setAttribute("empno", empno);
				request.setAttribute("Main", BoardDAO.getAllContents(vpage));
				request.setAttribute("admin_entity", BoardDAO.getAdminContents());
				request.getRequestDispatcher("board.do").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
    }
}
