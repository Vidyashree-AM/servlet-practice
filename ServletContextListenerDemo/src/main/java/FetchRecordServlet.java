

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		try {
			ServletContext ctx = getServletContext();
			Connection con = (Connection) ctx.getAttribute("connection");
			PreparedStatement ps =con.prepareStatement("select * from emp_tb");
					
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				pw.write("<br>" + rs.getInt(1) + " "+rs.getString(2)+ " "+ rs.getInt(3));
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pw.close();
	}
}
