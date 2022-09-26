package emp;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Servlet implementation class EmpSession
 */
@WebServlet("/session")
public class EmpSession extends HttpServlet implements HttpSessionBindingListener {

	private static EmpSession instance = null;
	private static Hashtable loginEmp = new Hashtable();
		
    public EmpSession() {
    	super();
    }
    
    public static EmpSession getInstance(){
    	if(instance == null) {
    		instance = new EmpSession();
    	}
    	return instance;
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
