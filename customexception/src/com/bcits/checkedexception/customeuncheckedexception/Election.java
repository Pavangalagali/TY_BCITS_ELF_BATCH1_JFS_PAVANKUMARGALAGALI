package com.bcits.checkedexception.customeuncheckedexception;

public class Election {

	public void vote(int age) {
		if (age > 18) {
			System.out.println("allow him to vote");
		} else {
			throw new AgeLimitException();
		}
	}
}
