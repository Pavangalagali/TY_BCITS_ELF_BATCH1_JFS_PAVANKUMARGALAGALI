package com.bcits.jdbcapp.connection;

public class MainMethodClass {
	public static void main(String[] args) {
		String str = "two";
		Connection ref = DriverManager.getConnection(str);   
		ref.print();
	}// end of main
}// end of class
