package com.javawork.four;

import java.util.ArrayList;

import com.javawork.third.Employee;

public class EmployeeList {

	public static void main(String[] args) {
		
		Employee e1 = new Employee("kiran", 10, "Manager");
		Employee e2 = new Employee("laxman", 12, "Sales");
		Employee e3 = new Employee("don", 2, "janiter");
		Employee e4 = new Employee("budda", 1, "MD");
		
		ArrayList<Employee> elist = new ArrayList<Employee>();
		
		elist.add(e1);
		elist.add(e2);
		elist.add(e3);
		elist.add(e4);
		
		int i=0;
		
		while(i < elist.size()) {
			
			System.out.println(elist.get(i));
			i++;
		}
		
	}

}
