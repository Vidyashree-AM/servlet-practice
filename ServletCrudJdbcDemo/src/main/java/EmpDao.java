import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

	public static Connection getConnection()
	{
		Connection con = null;
		try {

    		Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_schema","root","vidya123");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static int save(Employee e)
	{
		int status = 0;
		try {
			
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("Insert into Employee(name,password,email,country) values(?,?,?,?)");
			
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			
			status = ps.executeUpdate();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return status;
	}
	
	
	public static int update(Employee e)
	{
		int status=0;
		try {
			
			    Connection con = EmpDao.getConnection();
				PreparedStatement ps = con.prepareStatement("Update Employee set name=?,password=?,email=?,country=? where id=?");
				
				ps.setString(1, e.getName());
				ps.setString(2, e.getPassword());
				ps.setString(3, e.getEmail());
				ps.setString(4, e.getCountry());
				ps.setInt(5, e.getId());
				
				status = ps.executeUpdate();
				
				con.close();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return status;
	}
	
	public static int delete(int id)
	{
		int status =0;
		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from Employee where id =?");
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static Employee getEmployeeById(int id)
	{
		Employee e = new Employee();
		
		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * from Employee where id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
			
			con.close();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return e;
	}
	
	public static List<Employee> getAllEmployees()
	{
		List<Employee> emplist = new ArrayList<>();
		
		try {
			
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * from Employee");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				emplist.add(e);
			}
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return emplist;
	}
}
