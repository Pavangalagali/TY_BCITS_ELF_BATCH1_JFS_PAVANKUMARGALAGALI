package com.javawork.four;

import java.util.Comparator;

import com.javawork.third.Employee;

public class SortByCost implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		
		return (int) (o1.salary-o2.salary);
	}

}
