import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	public Connection getDBconnection()
	{
		Connection conn=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Registered successfully");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();//It is a method of Java’s throwable class which prints the throwable along with other details like the line number and class name where the exception occurred.
		}
		}
		try 
		{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMP","root","123456");//DriverManager.getConnection(url, user, password)
			System.out.println("Connection successfull\n");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		return conn;		
	}
}
