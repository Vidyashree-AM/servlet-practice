

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		Employee e = new Employee();
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setCountry(country);
		
		int status = EmpDao.save(e);
		if(status > 0)
		{
			pw.write("<p>Record Saved Sccessfll</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else
		{
			pw.write("Sorry unable to save record");
		}
	}

}
