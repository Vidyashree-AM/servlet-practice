

import java.sql.Connection;
import java.sql.DriverManager;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

public class MyListener implements ServletContextListener {


    public void contextInitialized(ServletContextEvent sce)  { 
         
    	try {
			
    		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_schema","root","vidya123");
			
			ServletContext context = sce.getServletContext();
			context.setAttribute("connection", con);
			
		} 
    	catch (Exception e)
    	{
			e.printStackTrace();
		}
    }


    public void contextDestroyed(ServletContextEvent sce)  { 
         
    }
	
}
