package com.ty.bcits.searching;

import com.ty.bcits.dsalgorithms.BubbleSort;
import com.ty.bcits.dsalgorithms.RandomArrayCreation;

public class SearchDuration {

	public static void main(String[] args) {
		
		int[] randomArray = RandomArrayCreation.arrayInput(250);
		System.out.println("Linear Search");
		SearchDurationAnalysis.linearSearchAnalysis(randomArray,25);
		
		int[] arr = BubbleSort.bubbleSort(randomArray);
		System.out.println("Binary Search");
		SearchDurationAnalysis.binarySearchAnalysis(randomArray,25);
		
		
		
	}
}
