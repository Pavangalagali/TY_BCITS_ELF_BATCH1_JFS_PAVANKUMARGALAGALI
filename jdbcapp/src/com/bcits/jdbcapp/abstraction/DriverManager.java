package com.bcits.jdbcapp.abstraction;

public class DriverManager {
	private DriverManager() {

	}

	public static Connection getConnection(String dbUrl) {
		Connection connection = null;
		if (dbUrl.equals("one")) {
			connection = new ClassX();
		} else {
			connection = new ClassY();
		}
		return connection;

	}// end of getConnection method
}// end of class
