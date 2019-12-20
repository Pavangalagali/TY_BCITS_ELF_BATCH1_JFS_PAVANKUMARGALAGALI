package com.javawork.patterns;

public class PatternFour {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 4; i++) {
			
			for (int j = 3; j >= i ; j--) {
				
				System.out.print(" ");				
			}
			
			for (int k = 1; k <=i ; k++) {
				
				System.out.print("*");				
			}
			
			System.out.println();
		}
		
		System.out.println("another pattern......."); 
		
        for (int i = 1; i <= 4; i++) {
			
			for (int j = 1; j < i ; j++) {
				
				System.out.print(" ");				
			}
			
			for (int k = 4; k >=i ; k--) {
				
				System.out.print("*");				
			}
			
			System.out.println();
		}

	}

}
