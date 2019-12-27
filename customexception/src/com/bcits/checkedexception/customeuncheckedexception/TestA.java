package com.bcits.checkedexception.customeuncheckedexception;

public class TestA {
	public static void main(String[] args) {
		Election ppl = new Election();
		try {
			ppl.vote(19);
		} catch (AgeLimitException e) {
			System.out.println(e.getMessage());
		}
	}
}
