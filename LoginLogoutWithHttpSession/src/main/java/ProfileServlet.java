

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		request.getRequestDispatcher("link.html").include(request, response);
		HttpSession session = request.getSession(false);
		
		if(session != null)
		{
			String n = (String) session.getAttribute("uname");
			pw.write("welcome to profile page"+ n);
		}
		else
		{
			pw.write("Login first");
			request.getRequestDispatcher("Login.html").include(request, response);
		}
		
		pw.close();
	}

}
