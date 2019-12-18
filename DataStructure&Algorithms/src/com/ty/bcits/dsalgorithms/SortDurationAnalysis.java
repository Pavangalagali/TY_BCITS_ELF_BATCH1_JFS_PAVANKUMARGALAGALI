package com.ty.bcits.dsalgorithms;

import java.time.Duration;
import java.time.Instant;

public class SortDurationAnalysis {

	public static void bubbleSortduration(int[] arr) {
		Instant start = Instant.now();
		int sortedArr[] =BubbleSort.bubbleSort(arr);
		DisplayOutputSortedArray.display(sortedArr);
		Instant end = Instant.now();
		Long duration =Duration.between(start, end).toMillis();
		double seconds = duration /1000.0 ;
		System.out.println();
		System.out.println("Bubblesort has taken  " +seconds +" seconds to complete the task" );
		System.out.println();
	}

public static void selectionSortduration(int[] arr1) {
	Instant start = Instant.now();
	int sortedArr[] =SelectionSort.selectionSort(arr1);
	DisplayOutputSortedArray.display(sortedArr);
	Instant end = Instant.now();
	Long duration =Duration.between(start,end).toMillis();
	double seconds = duration /1000.0 ;
	System.out.println();
	System.out.println("SelectionSort has taken " +seconds +" seconds to complete the task");
	System.out.println();
}

  public static void reversedarrayduration(int[] arr2) {
		Instant start = Instant.now();
		int reversedArr[] = ReversedArray.reverse(arr2);
		DisplayOutputSortedArray.display(reversedArr);
		Instant end = Instant.now();
		Long duration =Duration.between(start,end).toMillis();
		double seconds = duration /1000.0 ;
		System.out.println();
		System.out.println("Reverse array has taken  " +seconds +" seconds to complete the task");
		System.out.println();
  }
  
  public static void unsortedarrayduration(int[] arr3) {
		Instant start = Instant.now();
		System.out.println();
		DisplayOutputSortedArray.display(arr3);
		Instant end = Instant.now();
		Long duration =Duration.between(start,end).toMillis();
		double seconds = duration /1000.0 ;
		System.out.println();
		System.out.println("Unsorted array has taken " +seconds +" seconds to complete the tasks");
		System.out.println();
  }

}
