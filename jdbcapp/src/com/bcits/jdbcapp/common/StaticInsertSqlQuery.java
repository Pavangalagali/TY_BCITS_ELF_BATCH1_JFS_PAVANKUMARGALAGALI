package com.bcits.jdbcapp.common;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class StaticInsertSqlQuery {
	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		try {
			FileInputStream file = new FileInputStream("dbInfo.properties");
			Properties properties = new Properties();
			properties.load(file);

			// step 1 : load the driver
			Class.forName(properties.getProperty("drivername")).newInstance();

			// step 2 : get the db connection via driver
			connection = DriverManager.getConnection(properties.getProperty("dbUrl"), properties);

			// step 3: issue sql queries via connection
			stmt = connection.createStatement();
			int result = stmt.executeUpdate(properties.getProperty("query"));

			// step 4 : process the result returned by queries
			if (result != 0) {
				System.out.println("profile updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
