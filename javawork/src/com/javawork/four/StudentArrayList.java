package com.javawork.four;

import java.util.ArrayList;

import com.javawork.second.Student;

public class StudentArrayList {

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
		
		ArrayList<Student> slist = new ArrayList<Student>();
		
		slist.add(s1);
		slist.add(s2);
		slist.add(s3);
		slist.add(s4);
		
		int i=0;
		while(i < slist.size()) {
			
			System.out.println(slist.get(i));
			i++;
		}
		
	}

}
