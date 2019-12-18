package com.ty.bcits.dsalgorithms;

import java.util.Random;
import java.util.Scanner;

public class RandomArrayCreation {
	
	
	public static int[] arrayInput(int size) {
	
			Random random = new Random(); 
		    int[] arr = new int[size];
		    for (int i = 0; i < size; i++) {
		       arr[i] = random.nextInt(50);
		    }
		    return arr;		    
		}
	}
 


