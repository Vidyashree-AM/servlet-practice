

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
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
		
		request.getRequestDispatcher("link.html").include(request, response);
		
		String n = request.getParameter("name");
		String p = request.getParameter("password");
		
		if(p.equals("admin123"))
		{
			pw.write("you have logged in sucessfully");
			pw.write(" welcome "+ n);
			
			Cookie ck = new Cookie("name", n);
			response.addCookie(ck);
		}
		else 
		{
		   pw.write("username or password wrong, pls try again");
		   request.getRequestDispatcher("login.html").include(request, response);			
		}
		
		pw.close();
	}
}
