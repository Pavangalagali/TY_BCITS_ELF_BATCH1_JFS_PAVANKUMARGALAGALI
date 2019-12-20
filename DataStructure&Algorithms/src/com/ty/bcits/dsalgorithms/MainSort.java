package com.ty.bcits.dsalgorithms;

import java.util.Scanner;

public class MainSort {

	public static void main(String[] args) {
		int[] array = RandomArrayCreation.arrayInput(500);
		int[] array2 = RandomArrayCreation.arrayInput(500);
		int[] array3 = RandomArrayCreation.arrayInput(500);
		
	    
		SortDurationAnalysis.bubbleSortduration(array);
		System.out.println();
		SortDurationAnalysis.selectionSortduration(array2);
		System.out.println();
		SortDurationAnalysis.mergeSortduration(array3);
		
	}

}
