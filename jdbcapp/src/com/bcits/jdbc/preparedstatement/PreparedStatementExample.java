package com.bcits.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExample {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. load the driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// 2. get db connection via driver
			String dbUrl = "jdbc:mysql://localhost:3306/employee_management_info";
			con = DriverManager.getConnection(dbUrl, "root", "root");

			// 3. Issue Sql queries via connection
			String query = " select * from employee_primary_info " + " where empid=? ";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(args[0]));
			rs = pstmt.executeQuery();

			// 4 process the result returned by query
			if (rs.next()) {
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
				System.out.println("manager id  ====> " + managerId);
			} else {
				System.err.println("Employee Data Not Found!!");
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
				if (rs != null) {
					rs.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}// end of main
}// end of class
