package com.ty.bcits.dsalgorithms;

import java.time.Duration;
import java.time.Instant;

public class SortDurationAnalysis {

	public static void bubbleSortduration(int[] arr) {
		Instant start = Instant.now();
		int sortedArr[] =BubbleSort.bubbleSort(arr);
		Instant end = Instant.now();
		Long duration =Duration.between(start, end).toMillis();
		double seconds = duration /1000.0 ;
		System.out.println("Bubblesort has taken  " +seconds +" seconds to complete the task" );
		
	}


	public static void selectionSortduration(int[] arr) {
	Instant start = Instant.now();
	int sortedArr[] =SelectionSort.selectionSort(arr);
	Instant end = Instant.now();
	Long duration =Duration.between(start,end).toMillis();
	double seconds = duration /1000.0 ;	
	System.out.println("SelectionSort has taken " +seconds +" seconds to complete the task");
   }
	
	public static void mergeSortduration(int[] arr) {
		Instant start = Instant.now();
		MergeSort.mergeSort(arr, 0, arr.length-1);
		Instant end = Instant.now();
		Long duration =Duration.between(start,end).toMillis();
		double seconds = duration /1000.0 ;	
		System.out.println("MergeSort has taken " +seconds +" seconds to complete the task");
	   }

  

}
