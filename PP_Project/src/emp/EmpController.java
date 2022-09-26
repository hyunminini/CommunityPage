package emp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/empcon")
public class EmpController extends HttpServlet {
	
    public EmpController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{	
    	Integer empno = Integer.parseInt(request.getParameter("empno"));	
    	String pw = request.getParameter("pw");
//    	System.out.println(empno+pw);
  
    	boolean isCheck = false;
    	
    	request.setAttribute("empno", empno);
    	request.setAttribute("pw", pw);
//    	System.out.println("EmpController"+empno+pw);
    	
    	EmpDTO emp;
		try {
			emp = EmpDAO.loginTest(empno, pw);			
			if (emp !=null) {
				HttpSession session = request.getSession();
				session.setAttribute("empno", emp.getEmpno());
				session.setAttribute("pw", emp.getPw());
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
    }
}
