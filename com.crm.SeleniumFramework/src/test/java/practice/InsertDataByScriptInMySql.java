package practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataByScriptInMySql {

	public static void main(String[] args) throws Throwable {
		
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yantra", "root", "root");
		Statement stat = conn.createStatement();
		String query = "insert into workers(first_name,last_name,address,phone_number)value('laddu','koshta','India','1234567890')";
		//String query = "delete from workers where 'id' = 3";
		int result = stat.executeUpdate(query);
		if(result==1) {
			System.out.println("user is created");
		}
		else
		{
			System.out.println("user is not created");
		}
		conn.close();

	}

}
