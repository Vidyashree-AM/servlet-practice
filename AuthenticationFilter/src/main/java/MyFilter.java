

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;


public class MyFilter implements Filter {

  
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter pw = response.getWriter();
		
		String p = request.getParameter("password");
		if(p.equals("admin123"))
		{
			chain.doFilter(request, response);
		}
		else
		{
			pw.write("wrong name or password");
			RequestDispatcher rd=  request.getRequestDispatcher("index.html");
	        rd.include(request, response);
		}
		
		pw.close();
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
