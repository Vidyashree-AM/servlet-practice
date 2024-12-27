

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

public class ServeltInterfaceDemo implements Servlet {

	ServletConfig config = null;
	
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("Servlet is being initailzed");
	}

	
	public void destroy() {
		System.out.println("Servlet is being destroyed");
	}

	
	public ServletConfig getServletConfig() {
		return config;
	}


	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "COPYRIGHT 2007"; 
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.write("<html><body>");
		pw.write("<h1> Hello world </h1>");
		pw.write("</html></body>");
		
		pw.close();
	}

}
