package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException
	{
		Driver driver_ref=new Driver();
		
		//step 1:register the driver/database
		DriverManager.registerDriver(driver_ref);
		
		//step 2: Establish the connection with DB
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m4","root","root");
		
		//step 3:issue create statement
		Statement state = con.createStatement();
		
		//step 4:Execute Query
		int result = state.executeUpdate("insert into candidate_info values('nagarjun',5,'bangalore');");
		if(result==1)
		{
			System.out.println("Data Added");
		}
		
		ResultSet result1 = state.executeQuery("select * from candidate_info;");
		while(result1.next())
		{
			System.out.println(result1.getString(3)+"-"+result1.getString(2)+"-"+result1.getString(1));
		}
		
		//step 5:Close DB
		con.close();

	}

}
