package com.ty.bcits.dsalgorithms;

public class LinearSearch {
	
	
	public static void search(int arr[], int x) 
	{ 
	    int n = arr.length; 
	    int t = 0;
	    for(int i = 0; i < n; i++) 
	    { 
	        if(arr[i] == x) {
	        	System.out.print("The selected Element has found at index\n " +i ); 
	        	t=1;
	        	break;
	         } 
	      }
	    if(t != 1)
	    {
	        System.out.println("Please enter one of the element from the above given array !!!! ");
	        }
	        
	    } 
   }
