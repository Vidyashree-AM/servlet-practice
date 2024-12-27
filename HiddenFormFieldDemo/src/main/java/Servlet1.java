

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		pw.write("welcome "+ name);
		
		pw.write("<form action='Servlet2' method='get'>");
		pw.write("<input type='hidden' name='uname' value='"+name+"'>");
		pw.write("<input type='submit' value='go'>");
		pw.write("</form>");
		pw.close();
	}

}
