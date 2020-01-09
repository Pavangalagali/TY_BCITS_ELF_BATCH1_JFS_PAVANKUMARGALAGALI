package com.bcits.jdbc.preparedstatement;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class PreparedStatementInserSqlQuery {

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
			String query = "insert into employee_primary_info values(?,?,?,?," + "?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(args[0]));
			pstmt.setString(2, args[1]);
			pstmt.setLong(3, Long.parseLong(args[2]));
			pstmt.setString(4, args[3]);
			pstmt.setDate(5, sqlDate);
			pstmt.setDate(6, sqlDoj);
			pstmt.setString(7, args[4]);
			pstmt.setString(8, args[5]);
			pstmt.setDouble(9, Double.parseDouble(args[6]));
			pstmt.setInt(10, Integer.parseInt(args[7]));
			pstmt.setInt(11, Integer.parseInt(args[8]));

			int res = pstmt.executeUpdate();
			System.out.println(res);
//			step 5: process the results returned by sql query
			if (res > 0) {
				System.out.println("recored successfully");
			} else {
				System.err.println("record already exists");
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
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
