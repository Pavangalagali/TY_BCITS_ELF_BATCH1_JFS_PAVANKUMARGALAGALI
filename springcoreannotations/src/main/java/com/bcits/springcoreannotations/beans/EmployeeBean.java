package com.bcits.springcoreannotations.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Data;

@Data
public class EmployeeBean {
	
	private String name;
	private int age;
	
	@Autowired(required = false)
	@Qualifier("dev")
	private DepartmentBean departmentBean;
	
	/*
	 * @PostConstruct public void init() { System.out.println("Its init phase"); }
	 * 
	 * @PreDestroy public void destroy() { System.out.println("Its destroy phase");
	 * }
	 */
}
