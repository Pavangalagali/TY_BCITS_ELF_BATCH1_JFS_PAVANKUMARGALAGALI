package com.bcits.springcoreannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcoreannotations.beans.Car;

public class CarTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("carConfig.xml");
		 Car car =context.getBean("car", Car.class);
		 
		 System.out.println("Car Company : "+car.getCompany());
		 System.out.println("Engine CC   : "+car.getEngine().getCc());
		 System.out.println("Engine Type : "+car.getEngine().getType());
		 
	}
}
