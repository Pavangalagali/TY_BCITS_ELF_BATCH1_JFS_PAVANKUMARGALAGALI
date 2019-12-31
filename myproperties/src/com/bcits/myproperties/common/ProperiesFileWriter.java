package com.bcits.myproperties.common;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ProperiesFileWriter {
	public static void main(String[] args) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("dbInfo.properties");
			Properties properties = new  Properties();
			properties.setProperty("drivername", "com.mysql.jdbc.Driver");
			properties.setProperty("dbUrl", "jdbc:mysql://localhost:3306/employee_management_info");
			properties.setProperty("user", "root");
			properties.setProperty("password", "root");
			try {
				properties.store(fileOutputStream, "DB details");
				System.out.println("file created");
			} catch (IOException e) {

				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}// end of main 
}// end of class
