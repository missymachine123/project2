package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.Cookie;
import java.io.PrintWriter;


/**
 * Servlet implementation class s1
 */
public class s1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public s1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	Cookie c=new Cookie("user","Ariana");
    	c.setMaxAge(60*60*48);
    	response.addCookie(c);
    	out.println("<html><body><form action='s2'><button>Servlet 2</button></form></body></html>");
    }
    	/**
    	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    	*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(request, response);
    }
   }
