

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		request.getRequestDispatcher("link.html").include(request, response);
		
		Cookie ck[] = request.getCookies();
		if(ck != null)
		{
			String n = ck[0].getValue();
			if(n.equals(" ") || n != null)
			{
				pw.write("welcome to profile page");
				pw.write("welcome"+ n);
			}
		}
		else
		{
			pw.write("Please login first");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		
		pw.close();
	}

}
