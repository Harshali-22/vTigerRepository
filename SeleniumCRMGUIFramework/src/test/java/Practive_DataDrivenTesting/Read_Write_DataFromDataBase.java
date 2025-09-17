package Practive_DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Read_Write_DataFromDataBase {


		Connection con =null;
		public void getConnection(String url, String username,String password) throws SQLException{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			DriverManager.getConnection(url, username, password);
		}
		public void closeConnection() throws SQLException {
			con.close();
		}
		public ResultSet executeConSelectQuery(String query) throws SQLException {
			Statement statm=con.createStatement();
			ResultSet set=statm.executeQuery(query);
			
			return set;
		}
		
		public int executeConNonSelectQuery(String query) throws SQLException {
			int set;
			Statement statm=con.createStatement();
			set =  statm.executeUpdate(query);
			return set;
		}

	}
