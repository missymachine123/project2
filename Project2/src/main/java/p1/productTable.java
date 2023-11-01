package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class productTable {
	public static List<row> getProductTable(){
		ArrayList<row> productList=new ArrayList<>();
		//initializing the database connection
		Connection mycon=null;
		Statement sql_stmt=null;
		ResultSet records=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","12345");
			sql_stmt = mycon.createStatement();  
			records = sql_stmt.executeQuery("select * from products");
			while (records.next()) {
				row r=new row(records.getString("productID"), records.getString("ProductName"),records.getString("ProductDesc"),records.getString("pic"),records.getString("category"),records.getInt("qty"),records.getFloat("customerPrice"),records.getFloat("importedPrice"));
				productList.add(r);
			}
		}
		catch(Exception e) {e.printStackTrace();} 
		return productList;
	}
}
