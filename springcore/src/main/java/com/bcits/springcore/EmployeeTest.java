package com.bcits.springcore;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.EmployeeBean;

public class EmployeeTest {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeBean employeeBean = (EmployeeBean) context.getBean("employee");
		EmployeeBean employeeBean2 = (EmployeeBean) context.getBean("employee");

		System.out.print("Enter the Name : ");
		employeeBean.setName(scanner.nextLine());
		System.out.print("Enter the Age : ");
		employeeBean.setAge(scanner.nextInt());
		scanner.nextLine();
		
		System.out.print("Enter the Name : ");
		employeeBean2.setName(scanner.nextLine());
		System.out.print("Enter the Age : ");
		employeeBean2.setAge(scanner.nextInt());
		scanner.nextLine();

		System.out.println("Name = " + employeeBean.getName());
		System.out.println("Age  = " + employeeBean.getAge());
		System.out.println("Name = " + employeeBean2.getName());
		System.out.println("Age  = " + employeeBean2.getAge());
		
		scanner.close();
		
	}
}
