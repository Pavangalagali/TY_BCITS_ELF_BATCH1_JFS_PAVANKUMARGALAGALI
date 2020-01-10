package com.tyss.bcits.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class JavaSortSolution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the number of students");
		int totalNumber = Integer.parseInt(scanner.nextLine());
		List<Student> student = new ArrayList<Student>();
		while (totalNumber > 0) {

			System.out.println("enter the id");
			int id = Integer.parseInt(scanner.nextLine());
			System.out.println("enter the name");
			String name = scanner.nextLine();
			System.out.println("enter the cgpa");
			double cgpa = Double.parseDouble(scanner.nextLine());
			Student student1 = new Student(id, name, cgpa);
			student.add(student1);
			totalNumber--;
		}
		Collections.sort(student, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if (s2.getCgpa() > s1.getCgpa()) {
					return 1;
				} else if (s2.getCgpa() < s1.getCgpa()) {
					return -1;
				}
				return s1.getName().compareTo(s2.getName());
			}
		});
		for (Student student2 : student) {
			System.out.println(student2.getCgpa());
			System.out.println(student2.getName());
		}
	}
}
