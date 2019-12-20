package com.ty.bcits.dsalgorithms;

import java.time.Duration;
import java.time.Instant;

public class BubbleSortTest {


	public static void bestCaseBubbleSortduration(int[] arr) {
		Instant start = Instant.now();
		int sortedArr[] =BubbleSort.bubbleSort(arr);
		Instant end = Instant.now();
		Long duration =Duration.between(start, end).toMillis();
		double seconds = duration /1000.0 ;
		System.out.println("Best case Bubblesort has taken  " +seconds +" seconds to complete the task" );
		
	}
	public static void worstCaseBubbleSortduration(int[] arr) {
		Instant start = Instant.now();
		int sortedArr[] =BubbleSort.bubbleSort(arr);
		Instant end = Instant.now();
		Long duration =Duration.between(start, end).toMillis();
		double seconds = duration /1000.0 ;
		System.out.println("worst case Bubblesort has taken  " +seconds +" seconds to complete the task" );
		
	}
	public static void avgCaseBubbleSortduration(int[] arr) {
		Instant start = Instant.now();
		int sortedArr[] =BubbleSort.bubbleSort(arr);
		Instant end = Instant.now();
		Long duration =Duration.between(start, end).toMillis();
		double seconds = duration /1000.0 ;
		System.out.println("avg case Bubblesort has taken  " +seconds +" seconds to complete the task" );
		
	}
	

	
	public static void main(String[] args) {
		
		int[] arr = RandomArrayCreation.arrayInput(5000);	
		int[] sorted = BubbleSort.bubbleSort(arr);
		bestCaseBubbleSortduration(sorted);
		
		int[] rev = ReversedArray.reverse(arr);
		worstCaseBubbleSortduration(rev);
		
		int[] arr1 = RandomArrayCreation.arrayInput(5000);
		avgCaseBubbleSortduration(arr1);
		
		

	}

}
