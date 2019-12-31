package com.bcits.jdbcapp.staticqueries;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class UpdateStaticSqlQuery {
	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		try {
			FileInputStream file = new FileInputStream("dbInfo.properties");
			Properties properties = new Properties();
			properties.load(file);
			
			//step 1 : load the driver 
			Class.forName(properties.getProperty("drivername")).newInstance();
			
			//step 2 : get the bd connection via driver
			connection = DriverManager.getConnection(properties.getProperty("dbUrl"), properties);
			
			//step 3 : issue the sql query
			stmt = connection.createStatement();
			int result = stmt.executeUpdate(properties.getProperty("query1"));
			
			//step 4 : process the result returned by query
			System.out.println(result +" rows affected");
		} catch (Exception e) {
		
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
