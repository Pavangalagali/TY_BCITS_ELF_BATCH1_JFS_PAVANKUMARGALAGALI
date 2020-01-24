package com.bcits.springcore.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeBean {
	
	public EmployeeBean() {
		
	}
	
	private String name;
	private int age;
	private DepartmentBean departmentBean;

	/*
	 * public EmployeeBean(String name, int age, DepartmentBean departmentBean) {
	 * super(); this.name = name; this.age = age; this.departmentBean =
	 * departmentBean; }
	 */
	
}
