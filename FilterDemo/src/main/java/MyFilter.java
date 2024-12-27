

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
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
		pw.write("Before calling do filter");
		chain.doFilter(request, response);
		pw.write("After calling do filter");
		pw.close();
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
