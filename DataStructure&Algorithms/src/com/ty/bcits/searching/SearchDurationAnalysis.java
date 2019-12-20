package com.ty.bcits.searching;

import java.time.Duration;
import java.time.Instant;

public class SearchDurationAnalysis {
	
	public static void linearSearchAnalysis(int[] arr, int ele) {
		Instant s = Instant.now();
		LinearSearch.search(arr,ele);
		Instant e = Instant.now();
		Long duration =Duration.between(s, e).toMillis();
		double seconds = duration /1000.0 ;
		System.out.println("Linear Search has covered " +seconds +" seconds to complete the search" );
	}
	
	public static void binarySearchAnalysis(int[] arr, int ele) {
		Instant s = Instant.now();
		BinarySearch.search(arr,ele);
		Instant e = Instant.now();
		Long duration =Duration.between(s, e).toMillis();
		double seconds = duration /1000.0 ;
		System.out.println("Binary Search has covered " +seconds +" seconds to complete the search" );
	}
	
	

}
