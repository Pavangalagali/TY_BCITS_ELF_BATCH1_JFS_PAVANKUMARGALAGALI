package com.bcits.checkedexception.customecheckedexception;

public class SBIAtm {
 public static void main(String[] args) {
	ATMSimulator a1 = new ATMSimulator();
	try {
		a1.withdraw(41000);
	} catch (InsufficientBalance e) {
		System.out.println(e.getMessage());
	}
}
}
