package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class updateStudentTable
 */
@WebServlet("/employeeUpdateTable")
public class employeeUpdate extends HttpServlet {
private static final long serialVersionUID = 1L;
       
 
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Connection mycon2=null;
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	int x;
	int y;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	}
	try {
		mycon2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","12345");		
		PreparedStatement updateStmt = mycon2.prepareStatement("update products set quantity = ? where productID=?");
		updateStmt.setString(1, request.getParameter("quantity"));
		updateStmt.setString(2, request.getParameter("productID"));
		PreparedStatement updateStmt2 = mycon2.prepareStatement("update products set price = ? where productID=?");
		updateStmt2.setString(1, request.getParameter("price"));
		updateStmt2.setString(2, request.getParameter("productID"));
		x=updateStmt.executeUpdate();	
		y=updateStmt2.executeUpdate();
		
		if(x>0 || y>0) {
		out.println("succesfully updated the product table");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	/**
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}