package com.login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardDAO;
import emp.EmpDAO;
import emp.EmpDTO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public LoginController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pw = null;
		Integer empno = null;
    	EmpDTO emp = null;
    	

    	request.setAttribute("empno", empno);
    	request.setAttribute("pw", pw);
    	
		try {
			pw = request.getParameter("pw");
			empno = Integer.parseInt(request.getParameter("empno"));
			emp = EmpDAO.loginTest(empno, pw);
			
			System.out.println(emp);
			
			
			if (emp !=null) {
				HttpSession session = request.getSession();
	
				session.setAttribute("empno", emp.getEmpno());
				request.getRequestDispatcher("emp.do").forward(request, response);
			}else {
				response.sendRedirect("login.jsp");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
