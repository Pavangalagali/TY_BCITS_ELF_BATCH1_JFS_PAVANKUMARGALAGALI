package com.bcits.springcoreannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreannotations.beans.Pet;
import com.bcits.springcoreannotations.config.PetConfig;

public class PetTest {
	
	public static void main(String[] args) {
		
	ApplicationContext context = new AnnotationConfigApplicationContext(PetConfig.class);
	 Pet pet = context.getBean(Pet.class);
	 
	 System.out.println(" Name : "+pet.getName());
	 pet.getAnimal().speak();
	 pet.getAnimal().eat();
	
	


	}
}
