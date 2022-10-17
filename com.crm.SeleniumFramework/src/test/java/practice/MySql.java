package practice;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class MySql {

	public static void main(String[] args) throws Throwable{
		/*Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306//test_yantra", "root", "root");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yantra", "root", "root");
		Statement stat = conn.createStatement();
		String Quer = "select*from workers";
		ResultSet result = stat.executeQuery(Quer);
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));


		}
		conn.close();*/
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306//yantra", "root", "root");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yantra", "root", "root");
		Statement stat = con.createStatement();
		String query = "select*from workers";
		ResultSet result = stat.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5));
		}
		con.close();
	}

}
