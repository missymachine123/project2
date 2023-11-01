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
@WebServlet("/SaveCustomerInfo")
public class saveCustomerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public saveCustomerInfo() {
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
		Connection mycon=null;
		//ResultSet records=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","12345");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			PreparedStatement preSqlStmt=mycon.prepareStatement("Insert into customers values(?,?,?,?)");
			preSqlStmt.setString(1,request.getParameter("customerID")); //preSqlStmt.setInt(1,orderNo);
			preSqlStmt.setString(2,request.getParameter("customerName"));
			preSqlStmt.setString(3,request.getParameter("customerAddress"));
			preSqlStmt.setInt(4,Integer.parseInt(request.getParameter("cardID")));
			int x=preSqlStmt.executeUpdate();
			mycon.close();
			if(x>0)
			{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/saveOrder");
				rd.forward(request, response);
			}
		}
		catch(Exception e) {e.printStackTrace();} 
	}
}
