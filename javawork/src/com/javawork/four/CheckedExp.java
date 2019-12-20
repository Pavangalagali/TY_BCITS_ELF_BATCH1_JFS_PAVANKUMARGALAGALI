package com.javawork.four;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedExp {

	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\CBT\\Desktop\\java\\demo2.txt");

		try {
			FileReader fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
