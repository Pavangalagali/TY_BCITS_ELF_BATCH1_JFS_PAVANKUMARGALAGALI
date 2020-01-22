package com.bcits.springcore.beans;

import lombok.Data;

@Data
public class EmployeeBean {

	private String name;
	private int age;
	private DepartmentBean departmentBean;
	
	
}
