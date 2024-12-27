

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

//With jdbc
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		Connection con = (Connection) getServletContext().getAttribute("connection");
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String cntry = request.getParameter("country");
		
		System.out.println(name);
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into registration values(?,?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, pass);
			ps.setString(3, email);
			ps.setString(4, cntry);
			
			int i = ps.executeUpdate();
			if(i > 0)
				pw.write("Registered sucesss");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		pw.close();
	}

}
