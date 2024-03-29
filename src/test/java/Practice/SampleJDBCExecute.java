package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecute {

	public static void main(String[] args) throws SQLException {
	
		Driver driver_ref=new Driver();
		
		//register driver
		DriverManager.registerDriver(driver_ref);
		
		//Establish the connection with db
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m4", "root", "root");
		
		//issue create statement
		Statement state = con.createStatement();
		
		//execute query
		ResultSet result = state.executeQuery("select * from candidate_info;");
		while(result.next())
		{
			System.out.println(result.getString(1)+"-"+result.getInt(2)+"-"+result.getString(3));
		}
		//close db
		con.close();

	}

}
