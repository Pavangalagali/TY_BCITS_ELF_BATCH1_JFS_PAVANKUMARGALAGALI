package com.javawork.third;

import java.util.Scanner;

import javax.swing.text.AbstractDocument.BranchElement;

public class SearchEngine {

	/*
	 * search engine to search employee by passing name or id;
	 */
	public static void main(String[] args) {
		
		Employee e1 = new Employee("virat", 18, "Mech");
		Employee e2 = new Employee("rahul", 20, "ECE");
		Employee e3 = new Employee("manoj", 10, "CSE");
		Employee e4 = new Employee("shiva", 8, "Law");
		Employee e5 = new Employee("kiran", 23, "EEE");
		
		Employee[] employees = {e1, e2, e3, e4, e5};
		
		Scanner sc1= new Scanner(System.in);
		Scanner sc2= new Scanner(System.in);
		
		System.out.println("Search By : 1) name 2)id ");
		System.out.println("enter the choice");
		
		int choice = sc1.nextInt();
		switch(choice) {
		case 1: 
			System.out.println("enter the name of employee");
			System.err.print(search(employees,sc2.nextLine()));
			break;
		case 2:
			System.out.println("enter the id of the employee");
			System.err.print(search(employees,sc2.nextInt()));
			break;
		default :
			System.out.println("invalid option");
			break;
		}
	}
	public static String search(Employee[] emp, String name) {
		int i=0;
		int found =0;
		String details = null;
		while (i < emp.length) {
			
			if(name.equals(emp[i].name)) {
				System.out.println("details found.....");	
				System.out.println();
				details = "name = "+ emp[i].name +
						" id = " + emp[i].id+ " branch =  " + emp[i].branch;
				found = 1;
				break;
			}else {
				i++;
			}
				
		}
		if(found!=1) {
			return "details not found....";
		}
		return details;	
	}
	public static String search(Employee[] emp, int id) {
		
		int i=0;
		int found=0;
		String details="";
		while(i < emp.length) {
			
			if(id == emp[i].id) {
				System.out.println("details found.....");
				details = "name = "+ emp[i].name +
						" id = " + emp[i].id+ " branch =  " + emp[i].branch;
				found = 1;
				break;			
			}else {
				i++;
			}
		}
		if(found!=1) {
			return "details not found....";
		}
		return details;	
	}
}










