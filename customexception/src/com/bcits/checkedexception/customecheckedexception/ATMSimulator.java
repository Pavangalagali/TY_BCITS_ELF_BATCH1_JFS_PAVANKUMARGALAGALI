package com.bcits.checkedexception.customecheckedexception;

public class ATMSimulator {

	int balance = 40000;

	public void withdraw(int amount) throws InsufficientBalance {
		if(amount <= balance) {
			System.out.println("withdraw successful");
		}else {
			throw new InsufficientBalance();
		}
	}
}
