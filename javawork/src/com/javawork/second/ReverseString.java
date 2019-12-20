package com.javawork.second;

import java.util.Scanner;

public class ReverseString {

	public static String revereString(String arg) {
		
		String newString = "";
		
		for (int i = (arg.length()-1) ; i >= 0; i--) {
			
			newString = newString + arg.charAt(i);
		}
		
		return newString;
	}
	public static void main(String[] args) {
		
		String str ;
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("enter the string value");
		
		str=sc1.nextLine();
		
		String newString = revereString(str);
		
		System.out.println(newString);
		
	}
	
	

}
