package com.bcits.jdbc.preparedstatement;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class PreparedStatementUpdateSqlQuery {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		java.util.Date dob = new java.util.Date("10/10/1980");
		java.sql.Date sqlDate = new java.sql.Date(dob.getDate());

		java.util.Date doj = new java.util.Date("15/11/2009");
		java.sql.Date sqlDoj = new java.sql.Date(doj.getDate());

		try {
			FileInputStream inStream = new FileInputStream("dbInfo.properties");
			Properties properties = new Properties();
			properties.load(inStream);
			// step 1 : load the driver
			Class.forName(properties.getProperty("drivername")).newInstance();

			// step 2: get db connection via driver
			con = DriverManager.getConnection(properties.getProperty("dbUrl"), "root","root");

			// step 3: issue sql query
			String query = "update employee_primary_info "
					+ " set name = ? "
					+ " where empid = ? ";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, args[0]);
			pstmt.setInt(2, Integer.parseInt(args[1]));
			
			int res = pstmt.executeUpdate();
			System.out.println(res);
//			step 5: process the results returned by sql query
			if (res > 0) {
				System.out.println("updated successfully");
			} else {
				System.err.println("could not update");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		//step 5 :close all jdbc objects
		finally {
			// step 5 : close all jdbc objects
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
