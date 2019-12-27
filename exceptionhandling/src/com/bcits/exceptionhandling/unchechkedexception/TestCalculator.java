package com.bcits.exceptionhandling.unchechkedexception;

public class TestCalculator {

	public static void main(String[] args) {
		System.out.println("program running.................");
		Calculator c1 = new Calculator();
		c1.division(100, 5);
		c1.division(100, 0);
		c1.division(100, 50);
		c1.division(100, 20);
		System.out.println("program endend");
	}
}
