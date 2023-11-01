package p1;

import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/**
 * Servlet implementation class showShopCart
 */
@WebServlet("/showShopCartt")
public class showShopCart extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showShopCart() {
        super();
        // TODO Auto-generated constructor stub
    }
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	response.setContentType("text/html");
	PrintWriter out2=response.getWriter();
	out2.println("<html><head><title>Query Results</title></head><body>");
	out2.println("<table border='1' width='100%' cellpadding='6'>");
	out2.println("<tr>");
	out2.println("<th>&nbsp</th>");
	out2.println("<th>Product ID</th>");
	out2.println("<th>Product Name</th>");
	out2.println("<th>Product Description</th>");
	out2.println("<th>picture</th>");
	out2.println("</tr>");
	HttpSession session=request.getSession();
	ArrayList<row> shopCart=(ArrayList)session.getAttribute("sCart");
	if(shopCart==null)
		out2.println("<p>Empty Shop Cart!</p>");
	else
	{
		for(row r:shopCart)
	{
		out2.println("<tr><td>"+r.getProductName()+"</td></tr>");
	}
	}
		out2.println("</table><br />");
		out2.println("<p</p><center><a href='customerOrderInfo'> <button>Click</button> </a></center>");
	}

	/**
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
	}
}
