package com.javawork.five;

import java.io.*;

public class ReadWrite {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\CBT\\Desktop\\java\\demo.txt");
		char[] ch = new char[(int) file.length()];
		try {
			FileReader fr = new FileReader(file);
			fr.read(ch);
			System.out.println("reading done");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		File file2 = new File("C:\\Users\\CBT\\Desktop\\java\\demo1.txt");
		
		FileWriter fw = new FileWriter(file2);
		fw.write(ch);
		fw.flush();
		System.out.println("writing done");

	}

}
