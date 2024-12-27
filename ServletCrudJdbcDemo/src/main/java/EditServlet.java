

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.write("<h1>Update Employee</h1>");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		Employee e = EmpDao.getEmployeeById(id);
		
		System.out.println("Till now");
		pw.write("<form action='EditServlet1' method='post'>");
		pw.write("<table>");
		pw.write("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"' /></td></tr>");
		pw.write("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"' /></td></tr>");
		pw.write("<tr><td>Password</td><td><input type='password' name='pass' value='"+e.getPassword()+"' /></td></tr>");
		pw.write("<tr><td>Email</td><td><input type='text' name='email' value='"+e.getEmail()+"' /></td></tr>");
		pw.write("<tr><td>Country</td><td>");
		
		System.out.println("Till now1");
		
		pw.write("<select name='country'>");
		pw.write("<option>India</option>");
		pw.write("<option>Japan</option>");
		pw.write("<option>China</option>");
		
		pw.write("</td></tr>");
		pw.write("<tr><td><input type='submit' value='Edit and Save'></td></tr>");
		pw.write("</table>");
		pw.write("</form>");
		
		pw.close();
	}

}
