package com.ty.bcits.searching;

import com.ty.bcits.dsalgorithms.BubbleSort;
import com.ty.bcits.dsalgorithms.RandomArrayCreation;

public class MainSearch {

	public static void main(String[] args) {

		int[] randomArray = RandomArrayCreation.arrayInput(250);
		
		System.out.println("Linear Sear                  ");
	    LinearSearch.search(randomArray, 25);
		
		System.out.println();
		int[] arr = BubbleSort.bubbleSort(randomArray);
		
		System.out.println("Binary Search                ");
		BinarySearch.search(arr,25);
		

	}

}
