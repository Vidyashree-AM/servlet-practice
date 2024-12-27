

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			
			String n = request.getParameter("username");
			String p = request.getParameter("password");
			
			if(p.equals("servlet"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet");
				rd.forward(request, response);	
			}
			else {
				pw.write("username or pwd wrong");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
				
			}
			
			pw.close();
	}

}
