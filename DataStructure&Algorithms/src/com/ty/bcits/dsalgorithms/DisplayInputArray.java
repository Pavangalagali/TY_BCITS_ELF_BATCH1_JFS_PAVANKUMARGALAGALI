package com.ty.bcits.dsalgorithms;

public class DisplayInputArray {
	
	public static void display(int[] arr) {
		System.out.println("Displaying the Randomly populated array by using Random function ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
