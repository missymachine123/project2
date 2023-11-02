package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * Servlet implementation class saveCustomerInfo
 */
@WebServlet("/verify")
public class verifyEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public verifyEmployee() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	/**
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	/**
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String password = request.getParameter("pass");
			if(password.equals("employee"))
			{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/employeeArea.html");
				rd.forward(request, response);
			}else {
				out.print("Incorrect password");
			}
		}
		catch(Exception e) {e.printStackTrace();} 
	}
}