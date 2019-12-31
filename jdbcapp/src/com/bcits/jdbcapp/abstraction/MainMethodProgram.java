package com.bcits.jdbcapp.abstraction;

public class MainMethodProgram {
	public static void main(String[] args) {
		String dburl = "one";
		Connection con = DriverManager.getConnection(dburl);
		Statement stmt = con.createStatement();
		stmt.method2();
	}// End of main
}// end of class
