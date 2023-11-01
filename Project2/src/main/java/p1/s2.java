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
 * Servlet implementation class s2
 */
public class s2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public s2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	Cookie[] cArr=request.getCookies();
    	String username="";
    	if(cArr!=null)
    	{
    		for(int i=0; i<cArr.length; i++)
    		{
    			if(cArr[i].getName().compareTo("user")==0)
    				username=cArr[i].getValue();
    		}
    	}
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	out.println("<html><body><h1>Welcome "+username+"! </h1></body></html>");
    	}
    	/**
    	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    	*/
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(request, response);
    	}
   }