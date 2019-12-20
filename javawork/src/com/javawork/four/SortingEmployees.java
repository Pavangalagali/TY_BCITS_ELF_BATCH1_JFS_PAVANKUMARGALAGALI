package com.javawork.four;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import javax.swing.plaf.synth.SynthScrollBarUI;

import com.javawork.third.Employee;

public class SortingEmployees {

	public static void main(String[] args) {
		
		Employee e1 = new Employee("kiran", 10, "Manager",121);
		Employee e2 = new Employee("laxman", 12, "Sales",123);
		Employee e3 = new Employee("don", 2, "janiter", 157);
		Employee e4 = new Employee("budda", 1, "MD", 234);
		
		System.out.println("Sort by 1)id 2)name 3) salary");
		System.out.println("enter your choice");
		Scanner sc1 = new Scanner(System.in);
		TreeSet<Employee> elist = null;
		int choice = sc1.nextInt();
		switch(choice) {
		case 1:
			 elist = new TreeSet<Employee>();
			break;
		case 2:	
			SortByName sn = new SortByName();
			 elist = new TreeSet<Employee>(sn);
			break;
		case 3:
			SortByCost sl = new SortByCost();
			 elist = new TreeSet<Employee>(sl);
			break;
		default :
			System.out.println("invalid option");
            break;			
		}
		
		
		elist.add(e1);
		elist.add(e2);
		elist.add(e3);
		elist.add(e4);
		
		Iterator i1 = elist.iterator();
		
		while(i1.hasNext()==true) {
			
			System.out.println(i1.next());
		}

	}

}
