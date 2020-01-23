package com.bcits.springcoreannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.bcits.springcoreannotations.beans.EmployeeBean;
import com.bcits.springcoreannotations.config.AllConfigs;

public class EmployeeTest2 {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AllConfigs.class);
		EmployeeBean employeeBean = context.getBean(EmployeeBean.class);

		System.out.println("Employee Name = " + employeeBean.getName());
		System.out.println("Employee Age  = " + employeeBean.getAge());
		System.out.println("Department Id = " + employeeBean.getDepartmentBean().getDeptId());
		System.out.println("Dept Name     = " + employeeBean.getDepartmentBean().getDeptName());

	}
}
