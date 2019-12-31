package com.bcits.myproperties.common;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileReader {
	public static void main(String[] args) {
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream("dbInfo.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			System.out.println("driver name =====> " + properties.getProperty("drivername"));
			System.out.println("user =====> " + properties.getProperty("user"));
			System.out.println("password =====> " + properties.getProperty("password"));
			System.out.println("dburl =====> " + properties.getProperty("dbUrl"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
