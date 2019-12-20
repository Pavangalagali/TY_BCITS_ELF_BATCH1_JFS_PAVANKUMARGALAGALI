package com.ty.bcits.searching;

public class BinarySearch {
	
	public static void search(int a[],int num) { 
		
		int first=0;
		int last=a.length;
		int mid = (first + last)/2;  
		
		while( first <= last ) {  
		      if ( a[mid] < num ) {  
		        first = mid + 1;     
		} else if ( a[mid] == num ) {  
		        System.out.println("Number is found at " + ++mid + " position");  
		        break;  
		  } else {  
		         last = mid - 1;  
		  } mid = (first + last)/2;  
		   }
		if ( first > last ){  
		      System.out.println("Number is not found!");  
		   }  
		} 
	}
