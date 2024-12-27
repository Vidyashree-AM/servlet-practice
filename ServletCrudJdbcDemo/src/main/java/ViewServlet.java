
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.write("<a href='index.html'>Add New Employee</a>");
		pw.write("<h1>Employee List</h1>");
		
		List<Employee> emplist = EmpDao.getAllEmployees();
		
		pw.write("<table border='1' width='100%'>");
		pw.write("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>country</th><th>Edit</th><th>Delete</th></tr>");
		
		for(Employee e : emplist)
		{
			pw.write("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td><td>"+"<a href='EditServlet?id="+e.getId()+"'>edit</a></td><td>"
					+"<a href='DeleteServlet?id="+e.getId()+"'>Delete</a></td></tr>");
		}
		pw.write("</table>");
		
		pw.close();
	}

}
