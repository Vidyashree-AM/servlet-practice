

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		
		pw.write("welcome"+ name);
		HttpSession session = request.getSession();
		session.setAttribute("uname", name);
		
		ServletContext ctx = getServletContext();
		int c =(int) ctx.getAttribute("cur");
		int t = (int) ctx.getAttribute("total");
		
	    pw.write("<br> Total users:"+t)	;
	    pw.write("current users"+ c);
	    pw.write("<br> <a href='LogotServlet'>Logot</a>");
	    
	    pw.close();
	    
	}
}
