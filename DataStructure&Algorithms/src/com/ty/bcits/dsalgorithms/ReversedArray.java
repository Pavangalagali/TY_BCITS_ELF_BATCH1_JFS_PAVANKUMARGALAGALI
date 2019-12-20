package com.ty.bcits.dsalgorithms;

public class ReversedArray {
	
	public static int[] reverse(int a[])
	{ 
		int[] b = new int[a.length]; 
		int j = a.length; 
		for (int i = 0; i < a.length; i++) { 
			b[j - 1] = a[i]; 
		    j = j - 1; 
		    }
		return b;
		}
	}
