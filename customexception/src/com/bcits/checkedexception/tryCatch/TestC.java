package com.bcits.checkedexception.tryCatch;

public class TestC {
	public static void main(String[] args) {
		System.out.println("started...........");
		try {
			A.a();
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("ended............");
	}
}
