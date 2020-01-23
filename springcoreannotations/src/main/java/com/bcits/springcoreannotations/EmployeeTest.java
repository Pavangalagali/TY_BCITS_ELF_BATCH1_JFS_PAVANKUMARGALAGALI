package com.bcits.springcoreannotations;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreannotations.beans.EmployeeBean;
import com.bcits.springcoreannotations.config.EmployeeConfig;

public class EmployeeTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		((ConfigurableApplicationContext)context).registerShutdownHook();
		EmployeeBean employeeBean = context.getBean(EmployeeBean.class);

		System.out.print("Enter Employee-1 Name : ");
		employeeBean.setName(scanner.nextLine());

		System.out.print("Enter Employee-1  Age : ");
		employeeBean.setAge(scanner.nextInt());
		scanner.nextLine();
		
		EmployeeBean employeeBean2 = context.getBean(EmployeeBean.class);

		System.out.print("Enter Employee-2 Name : ");
		employeeBean2.setName(scanner.nextLine());

		System.out.print("Enter Employee-2  Age : ");
		employeeBean2.setAge(scanner.nextInt());
		System.out.println();
		System.out.println("*************** Employee 1 ******************");
		System.out.println("Name : " + employeeBean.getName());
		System.out.println("Age  : " + employeeBean.getAge());
		System.out.println("*************** Employee 2 ******************");
		System.out.println("Name : " + employeeBean2.getName());
		System.out.println("Age  : " + employeeBean2.getAge());
	}// end of main
}// end of class
