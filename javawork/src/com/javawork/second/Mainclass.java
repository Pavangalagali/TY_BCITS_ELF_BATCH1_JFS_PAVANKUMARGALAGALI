package com.javawork.second;

import java.util.ArrayList;

public class Mainclass {
	
	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.setId(10);
		s1.setName("virat");
		s1.setStandard("9");
		s1.setMarks(560);
		
		Student s2 = new Student();
		s2.setId(12);
		s2.setName("rahul");
		s2.setStandard("8");
		s2.setMarks(490);
		
		Student s3 = new Student();
		s3.setId(18);
		s3.setName("ram");
		s3.setStandard("9");
		s3.setMarks(586);
		
		Student s4 = new Student();
		s4.setId(13);
		s4.setName("ms");
		s4.setStandard("10");
		s4.setMarks(350);
		
		Student[] sList = {s1 ,s2 ,s3 ,s4};
		
		for (int i = 0; i < sList.length; i++) {
			
			System.out.println(sList[i]);
		}
	}

}
