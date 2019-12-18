package com.ty.bcits.dsalgorithms;

import java.util.Scanner;

public class MainSort {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the size of array : ");
		int size = s.nextInt();
		int[] array = RandomArrayCreation.arrayInput(size);
		SortDurationAnalysis.bubbleSortduration(array);
		SortDurationAnalysis.selectionSortduration(array);
		SortDurationAnalysis.reversedarrayduration(array);
		SortDurationAnalysis.unsortedarrayduration(array);
		
	}

}
