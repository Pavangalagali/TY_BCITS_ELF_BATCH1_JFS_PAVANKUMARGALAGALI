package com.bcits.checkedexception.tryCatch;

public class TestB {
	public static void main(String[] args) {
		String name = null;
		System.out.println("program started.............");
		try {
			try {
				System.out.println(100 / 0);
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(name.length());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("program ended-------------------");
	}
}
