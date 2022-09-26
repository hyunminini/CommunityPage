package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pp.model.EmpDAO;


@WebServlet("/ppcontroller")
public class PPController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "error.jsp";
		try {
			request.setAttribute("list", EmpDAO.getAllContents());
			url = "list.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "모두 보기 실패 재 실행 해 주세요");
		}	
		request.getRequestDispatcher(url).forward(request, response);
	}

	
}
