package com.ty.bcits.dsalgorithms;

import java.util.Scanner;

public class MainSearch {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Input the size of the array : ");
		int size = sc1.nextInt();
		int[] randomArray = RandomArrayCreation.arrayInput(size);
		DisplayInputArray.display(randomArray);
		System.out.println("Input the element to search in the given array ");
		int element = sc1.nextInt();
		System.out.println("\n                Linear Sear                  \n");
	    LinearSearch.search(randomArray, element);
		System.out.println("\n                Duration Check               \n");
		SearchDurationAnalysis.linearSearchAnalysis(randomArray,element);
		System.out.println("\n.............................................\n");
		System.out.println("\n                Binary Search                 \n");
		BinarySearch.search(randomArray,element);
		System.out.println("\n                Duration Check                 \n");
		SearchDurationAnalysis.binarySearchAnalysis(randomArray,element);

	}

}
