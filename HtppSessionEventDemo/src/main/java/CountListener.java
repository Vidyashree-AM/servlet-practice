import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener{

	ServletContext ctx = null;
	static int total=0,cur=0;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		total++;
		cur++;
		
		ctx = se.getSession().getServletContext();
		ctx.setAttribute("total", total);
		ctx.setAttribute("cur", cur);
		System.out.println("Session created");
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		cur--;
		ctx.setAttribute("cur", cur);
		System.out.println("Session destroed");
	}
	
}
