package com.tyss.bcits.hackerrank;

import java.util.Scanner;

public class TwoDArray1Solution {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int sum =0;
		System.out.println("---------------2D array--------------------------");
		System.out.println("enter the column number");
		int column = scanner.nextInt();
		System.out.println("enter the number of rows");
		int rows = scanner.nextInt();
        int[][] array = new int[rows][column];
        
        for (int i = 0; i < array.length; i++) {
			System.out.println("enter the values for");
			for (int j = 0; j < array[i].length; j++) {
				 array[i][j] = scanner.nextInt();
			}
		}
        for (int i = 0; i < array.length; i++) {
	
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
			
		}
        for (int i = 0; i < array.length; i++) {
        	
			for (int j = 0; j < array[i].length; j++) {
				sum = sum+ array[i][j];
			}
			
		}
        System.out.println(sum);
        scanner.close();
	}

}
