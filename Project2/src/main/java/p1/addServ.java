package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class updateStudentTable
 */
@WebServlet("/addServ")
public class addServ extends HttpServlet {
private static final long serialVersionUID = 1L;
       
 
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Connection mycon2=null;
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<html><head><title>Query Results</title><link rel=\"stylesheet\" type=\"text/css\" href=\"one.css\" /></head><body><center>");
//out.println("Changing 90011's grade to 85");
//out.println("<a href='studentTest'> <button>Click Me!</button> </a>");
int x = 0;
try {
Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
try {
out.println("work");
mycon2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","12345");
PreparedStatement updateStmt = mycon2.prepareStatement("INSERT INTO products VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
	
	updateStmt.setInt(1, request.getParameter("id"));
	updateStmt.setString(2, request.getParameter("name"));
	updateStmt.setString(3,request.getParameter("d"));
	updateStmt.setString(4, request.getParameter("pic"));
	updateStmt.setString(5, request.getParameter("cat"));
	updateStmt.setInt(6, request.getParameter("q"));
	updateStmt.setFloat(7, request.getParameter("pr"));
	updateStmt.setFloat(8, request.getParameter("ipr")); 
	//updateStmt2.executeUpdate();
x=updateStmt.executeUpdate();
if(x>0) {
out.println("Product has been added.");
out.println("Check updated list.");
out.println("<p</p><center><a href='productList'> <button>Click</button> </a></center>");
} else {
	out.println("An issue occured. Please try again.");
	out.println("<a href='addEmployee.html'> <button>Click</button> </a>");
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