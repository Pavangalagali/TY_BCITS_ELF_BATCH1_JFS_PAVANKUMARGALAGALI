package com.javawork.patterns;

public class PatternFive {

	public static void main(String[] args) {
		
		int n=2;
		
		for (int i = 1; i <= 4; i++) {
			
			for (int j = 3; j >= i ; j--) {
				
				System.out.print(" ");
				
			}
			
			for (int k = 1; k < n; k++) {
				
				System.out.print("*");
			}
			n = n + 2;
			System.out.println();

		}
		
	}

}
