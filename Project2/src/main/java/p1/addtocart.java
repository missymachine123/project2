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
        ArrayList previousProducts=(ArrayList)session.getAttribute("previousProducts");
        PrintWriter out=response.getWriter();
        if(previousProducts==null) {
            previousProducts=new ArrayList();
            session.setAttribute("previousProducts", previousProducts);
        }
        String newProdID=request.getParameter("productid");
        if(newProdID!=null)
        {
            previousProducts.add(newProdID);
            
        }
        
        out.println("<html><head><title>ADD to Cart</title></head><body>");
        if(previousProducts.size()==0) {
            out.println("<h2>Empty Cart!</h2>");
            
        }
        else {
            out.println("<table border='1'>");
            for(int i=0; i<previousProducts.size(); i++) {
                out.println("<tr><td>"+previousProducts.get(i)+"</tr></td>");
            }
            out.println("</table>");
        }
         
        out.println("<p>you have add to the cart:"+request.getParameter("productid")+"</p>");
        out.println("</body></html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
