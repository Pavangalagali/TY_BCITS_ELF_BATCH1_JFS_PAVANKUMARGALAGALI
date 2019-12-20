package com.javawork.third;

public class Employee implements Comparable {

	public String name;
	int id;
	String branch;
	public double salary;
	
	public Employee(String name, int id, String branch, double salary) {
		super();
		this.name = name;
		this.id = id;
		this.branch = branch;
		this.salary = salary;
	}

	public Employee() {
		super();
	}

	public Employee(String name, int id, String branch) {
		super();
		this.name = name;
		this.id = id;
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", branch=" + branch + "]";
	}

	@Override
	public int hashCode() {
		
		return id;
	}

	@Override
	public int compareTo(Object o) {
		return this.hashCode()-o.hashCode();
		
	}
	
	
}












