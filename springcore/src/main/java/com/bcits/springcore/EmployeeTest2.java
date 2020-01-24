package com.bcits.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.EmployeeBean;

public class EmployeeTest2 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("importAllConfigs.xml");
		EmployeeBean employeeBean =  context.getBean("employee", EmployeeBean.class);
	
		System.out.println("     Name : "+employeeBean.getName());
		System.out.println("      Age : "+employeeBean.getAge());
		System.out.println("Dept Id   : "+employeeBean.getDepartmentBean().getDeptId());
		System.out.println("Dept Name : "+employeeBean.getDepartmentBean().getDeptName());
	}
}
