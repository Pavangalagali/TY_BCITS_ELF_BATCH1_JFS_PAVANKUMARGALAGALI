package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.print.attribute.standard.Finishings;

import com.mysql.jdbc.Driver;

public class FindEmployee {
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// Step 1 : Load the driver

			// Driver dRef = new Driver(); DriverManager.registerDriver(dRef);

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Step 2 : get the db connection via driver
			String dbUrl = "jdbc:mysql://localhost:3306/employee_management_info?user=root&password=root";
			System.out.println("----------------------------");
			con = DriverManager.getConnection(dbUrl);
			System.out.println("----------------------------");
			// Step 3 : issue sql queries via connection
			String query = " select * from employee_primary_info " + " where empid = 10 ";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			// step 4 : process the result returned by sql query
			while (rs.next()) {
				int employeeId = rs.getInt("empid");
				String name = rs.getString("name");
				long mobileNo = rs.getLong("mobileno");
				String mailId = rs.getString("official_maildid");
				Date date_of_birth = rs.getDate("date_of_birth");
				Date joined_on = rs.getDate("date_of_joining");
				String designation = rs.getString("designation");
				String blood_group = rs.getString("blood_group");
				double salary = rs.getDouble("salary");
				int deptId = rs.getInt("deptid");
				int managerId = rs.getInt("mgrid");

				System.out.println("id        ======> " + employeeId);
				System.out.println("name      ======> " + name);
				System.out.println("mobile no ======> " + mobileNo);
				System.out.println("mail id   ======> " + mailId);
				System.out.println("DOB       ======> " + date_of_birth);
				System.out.println("joining date ===> " + joined_on);
				System.out.println("desgination  ===> " + designation);
				System.out.println("blood group ====> " + blood_group);
				System.out.println("salary    ======> " + salary);
				System.out.println("dept Id   ======> " + deptId);
				System.out.println("manager id ====> " + managerId);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			// step 5 : close all jdbc objects
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
