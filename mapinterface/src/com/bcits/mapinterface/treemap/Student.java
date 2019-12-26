package com.bcits.mapinterface.treemap;

public class Student implements Comparable<Student> {

	String name;
	int id;

	public Student(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + "]";
	}

	@Override
	public int compareTo(Student o) {
		return this.name.compareTo(o.name);
	}

}
