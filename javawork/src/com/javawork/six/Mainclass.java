package com.javawork.six;

import java.util.Scanner;

public class Mainclass  {
 
	/*
	 *   1) using lamda fun to add two number
	 *   2) factorial using lamda function
	 *   3) printing message using lamda function
	 *   4) finding square of number using lamda function
	 *   5) printing numbers of given range lamda function
	 */
	
	public static void main(String[] args) {
				
		AddTwoNumbers addition = (int num1, int num2) -> {
			
			System.out.println(	num1+num2 );
			};
			
		Factorial fact =(int n) -> {
				
				int facto =1;
				while(n>0) {
					 
					facto = facto *n;
					n--;
				}
				return facto;
			};
		PrintMessage print = (String msg) -> System.out.println(msg);
			
		Square snumber = (int n) ->  n*n;
		
		RangeNumber range = (int n) -> {
			
			for (int i = 1; i <= n; i++) {
				
				System.out.println(i);
			}
		};
     
		System.out.println("----------------1-----------------------------");
		addition.add(10, 5);
		System.out.println("----------------2-----------------------------");
		System.out.println( fact.factorial(5) );
		System.out.println("----------------3-----------------------------");
		print.printIt("hello RCBian");
		System.out.println("----------------4-----------------------------");
		System.out.println( snumber.square(5));
		System.out.println("----------------5-----------------------------");
        range.printNumberRange(10);
		
		
	}

}
