

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			
			String n = request.getParameter("name");
			pw.write("welcome "+ n);
			
			Cookie ck = new Cookie("name", n);
			response.addCookie(ck);
			
			pw.write("<form action='Servlet2' method='post'>");
			pw.write("<input type='Submit' value='go'>");
			pw.write("</form>");
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
