

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.io.PrintWriter;


public class MyFilter extends HttpFilter implements Filter {
       
	FilterConfig config = null;
    
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter pw = response.getWriter();
		String param = config.getInitParameter("Construction");
		if(param.equals("yes"))
		{
			pw.write("This page is under processing");
		}
		else
		{
			chain.doFilter(request, response);
		}
		
		pw.close();
	}


	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

}
