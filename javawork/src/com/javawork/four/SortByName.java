package com.javawork.four;

import java.util.Comparator;

import com.javawork.third.Employee;

public class SortByName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		String name1 = o1.name;
		String name2 = o2.name;
		
		return name1.compareTo(name2);
	}
	
	

}
