package com.ty.bcits.algorithms;

import java.time.Duration;
import java.time.Instant;

public class AlgorithmAnalysis {

	public static Long addUpto(Long number) {
		
		Long total = 0L;
		for (Long i = 0L; i <= number; i++) {
				total+=i;			
		}
		return total;
	}
	
	public static Long addUptoQuick(Long number) {
		
		return number * (number + 1) / 2;
	}
	
	public static void countDurationaddUpto() {
		Long number = 9999999999L;
		Instant start = Instant.now();
		System.out.println(addUpto(number));
		Instant end = Instant.now();
		
		long duration = Duration.between(start, end).toMillis();
		
		double seconds = duration / 1000;
		System.out.println("addupto() took " + seconds);
	}
	public static void countDurationaddUptoQuick() {
		Long number = 9999999999L;
		Instant start = Instant.now();
		System.out.println(addUptoQuick(number));
		Instant end = Instant.now();
		
		long duration = Duration.between(start, end).toMillis();
		
		double seconds = duration / 1000;
		System.out.println("addUptoQuick() took " + seconds);
	}
	
	public static void main(String[] args) {
		countDurationaddUptoQuick();
		countDurationaddUpto();
	}
	
	
	
}
