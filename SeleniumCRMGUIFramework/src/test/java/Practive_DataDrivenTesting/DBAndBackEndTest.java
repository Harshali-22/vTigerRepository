package Practive_DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DBAndBackEndTest {

	
		@Test
		public void projectCheckTest() throws SQLException {
			String projectName="Insta_022";
			boolean flag=false;
		
			// verify the project in DB
			
	//step 1: load/register the database driver
			Driver driverRef= new Driver();
			DriverManager.registerDriver(driverRef);
	//Step2: connect to dataBase
			Connection con=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root");
				System.out.println("====Done===");
	//Step3: Create sql statement
				Statement stat=con.createStatement();
	//Step4: Execute select query & get result
				ResultSet resultSet=stat.executeQuery("select * from project");
				while (resultSet.next()) {
					String actProjectName=resultSet.getString(4);
					if (projectName.equals(actProjectName)) {
						flag=true;
						System.out.println(projectName + "is available === PASS");
					}
				}
			if (flag==false) {
				System.out.println(projectName + "is available === FAIL");
			}
			con.close();
	}

}
