

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
			HttpSession session = request.getSession();
			session.setAttribute("uname", n);
			
			pw.write("Logged in Sucessfull");
		}
		else
		{
			pw.write("Name or password wrong");
			request.getRequestDispatcher("Login.html").include(request, response);
		}
		
		pw.close();
	}

}
