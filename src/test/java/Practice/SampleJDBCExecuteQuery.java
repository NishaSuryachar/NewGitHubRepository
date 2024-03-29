package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws SQLException
	{
		Driver driver_ref=new Driver();
		
		//step 1: register the driver/database
		DriverManager.registerDriver(driver_ref);
		
		//step 2:Establish the connection with db
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m4", "root", "root");
		
		//step 3: issue Create Statement
		Statement state = con.createStatement();
	    
		//step 4:execute query
		ResultSet result = state.executeQuery("select * from candidate_info;");
		while(result.next())
		{
			System.out.println(result.getString(3)+"-"+result.getString(2)+"-"+result.getString(1));
		}
		
		//step 5: close db
		con.close();
		
		

	}

}
