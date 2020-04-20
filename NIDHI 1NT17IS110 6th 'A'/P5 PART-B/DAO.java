
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO 
{
	
	public int insertemp(Employee e)
	{
		int r=0;
		Connection conn=new DBConnection().getDBconnection();
		try 
		{
			PreparedStatement pst=conn.prepareStatement("insert into employee values(?,?,?,?)");//The PreparedStatement interface is a subinterface of Statement. It is used to execute parameterized query.
			pst.setString(1, e.getName());
			pst.setInt(2, e.getAge());
			pst.setString(3, e.getDept());
			pst.setDouble(4, e.getSal());
			r=pst.executeUpdate();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return r;
	}
	
	public int deleteemp(String emp)
	{
		int s=0;
		Connection conn=new DBConnection().getDBconnection();
		try 
		{
			PreparedStatement pst=conn.prepareStatement("delete from employee where name=?");
			pst.setString(1, emp);
			s=pst.executeUpdate();// The executeUpdate( ) method works just like the execute( ) method, except that it returns an integer value that reports the number of rows affected by the SQL statement
		} 
		catch (SQLException e1)
		{	
			e1.printStackTrace();//It is a method of Java’s throwable class which prints the throwable along with other details like the line number and class name where the exception occurred.
		}
		return s;
	}
	
	public void displayname(String ename)
	{
		Connection conn=new DBConnection().getDBconnection();
		try 
		{
				PreparedStatement pst = conn.prepareStatement("select * from employee where name=?");
				pst.setString(1, ename);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					System.out.println("Name : " +rs.getString(1)+ "\t"+  "Age : " +rs.getInt(2)+ "\t"+ "Dept :" +rs.getString(3)+ "\t"+ "Salary :" +rs.getDouble(4));;
				}
		}
		catch (SQLException e) 
		{
				e.printStackTrace();
		}
	
	}
	
	public void displayall()
	{
		Connection conn=new DBConnection().getDBconnection();
		try 
		{	
			PreparedStatement pst=conn.prepareStatement("select * from employee");
			ResultSet rs=pst.executeQuery();//execute Select queries and returns the ResultSet.
			while(rs.next())
			{
				System.out.println("Name : " +rs.getString(1)+ "\t"+  "Age : " +rs.getInt(2)+"\t"+ "Dept :" +rs.getString(3)+"\t" + "Salary :" +rs.getDouble(4));;
			}
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
	}
}