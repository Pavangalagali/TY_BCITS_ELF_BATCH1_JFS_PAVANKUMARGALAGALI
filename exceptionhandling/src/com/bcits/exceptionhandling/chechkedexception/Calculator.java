package com.bcits.exceptionhandling.chechkedexception;

public class Calculator {

	public void division() {
		try {
			Class.forName("person");
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR 404 - class not found");
		}
	}
}
