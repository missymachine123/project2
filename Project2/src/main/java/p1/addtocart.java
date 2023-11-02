package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
/**
 * Servlet implementation class addtocart
 */
@WebServlet("/addtocart2")
public class addtocart extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtocart() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	HttpSession session=request.getSession();
    	     ArrayList<row> shopCart=(ArrayList)session.getAttribute("sCart");
    	     PrintWriter out=response.getWriter();
    	     if (shopCart == null) {
    	    shopCart = new ArrayList();
    	    session.setAttribute("sCart", shopCart);
    	     }
    	     String Id, name, desc, pic;
    	     float price;
    	     int qty;
    	     Id=request.getParameter("productid");
    	     name=request.getParameter("productName");
    	     desc=request.getParameter("productDesc");
    	     pic=request.getParameter("pic");
    	     price=Float.parseFloat(request.getParameter("customerPrice"));
    	     qty=Integer.parseInt(request.getParameter("qtyOrder"));
    	     
    	     
    	     row Item=new row(Id, name, desc, pic, "teeth" ,qty, price,0);
    	     shopCart.add(Item);
    	     session.setAttribute("sCart", shopCart);
    	     RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/showShopCart");
    	     RequetsDispatcherObj.forward(request, response);
    	     
    	     
    	}
    	/**
    	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    	*/
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(request, response);
    	}
    	}
