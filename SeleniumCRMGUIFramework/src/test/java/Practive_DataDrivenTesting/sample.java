package Practive_DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class sample {

	public static void main(String[] args) throws Exception {
		Connection con=null;
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		System.out.println("===Executed===");
		}
		catch(Exception e ) {
			System.out.println("Exception handled");
		}
		finally {
			con.close();
			System.out.println("===Executed===");
		}
	}
}
