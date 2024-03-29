package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdate {

	public static void main(String[] args) throws SQLException 
	{
		Driver driver_ref=new Driver();
		
		//register driver
		DriverManager.registerDriver(driver_ref);
		
		//establish connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m4", "root", "root");
		
		//issue create statement 
		Statement state = con.createStatement();
		
		//execute query
		int result = state.executeUpdate("insert into candidate_info values('mahavera','2','bankok');");
		if(result==1)
		{
			System.out.println("Data Added");
		}
		ResultSet result1 = state.executeQuery("select * from candidate_info;");
		while(result1.next())
		{
			System.out.println(result1.getString(1)+"-"+result1.getInt(2)+"-"+result1.getString(3));
		}
		//close database
		con.close();
		

	}

}
