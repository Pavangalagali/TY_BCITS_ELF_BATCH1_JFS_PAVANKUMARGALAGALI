package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class MyFirstJDBCProgram {
	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			// step 1 : load the driver
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);

			// step 2 : get the connection via driver
			String dbUral = "jdbc:mysql://localhost:3306/employee_management_info";
			con = DriverManager.getConnection(dbUral, "root", "root");

			// Step 3 : issue the sql queries via connection
			String query = " select * from employee_primary_info";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			// step 4 : process the result returned by connection
			while (rs.next()) {
				int employeeID = rs.getInt("empid");
				String name = rs.getString("name");
				Long mobileno = rs.getLong("mobileno");
				String mailId = rs.getString("official_maildid");
				Date birthdate = rs.getDate("date_of_birth");
				Date joinedOn = rs.getDate("date_of_joining");
				String designation = rs.getString("designation");
				String bloodGroup = rs.getString("blood_group");
				double salary = rs.getDouble("salary");
				int deptId = rs.getInt("deptid");
				int managerId = rs.getInt("mgrid");

				System.out.println("employee id      ==> " + employeeID);
				System.out.println("name of employee ==>" + name);
				System.out.println("mobile number    ==> " + mobileno);
				System.out.println("maild id         ==> " + mailId);
				System.out.println("date of birth    ==> " + birthdate);
				System.out.println("date of joing    ==>" + joinedOn);
				System.out.println("working as       ==> " + designation);
				System.out.println("blood group      ==> " + bloodGroup);
				System.out.println("salary           ==> " + salary);
				System.out.println("working in dept number ==> " + deptId);
				System.out.println("manager id       ==> " + managerId);
				System.out.println("------------------------------------------");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// step : close all the jdbc objects
			try {
				if (con != null) {
					con.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} // end of finally block
	}// End of main
}// end of class
