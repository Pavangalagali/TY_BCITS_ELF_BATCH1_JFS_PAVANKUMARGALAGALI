package com.bcits.checkedexception.tryCatch;

public class TestA {
	public static void main(String[] args) {
		String name = null;
		System.out.println("program started................");
		try {
			System.out.println(name.length());
			System.out.println(100 / 0);
		} catch (ArithmeticException | NullPointerException e) {
			System.out.println(e.getMessage());
		} 
		System.out.println("program ended...................");
	}
}
