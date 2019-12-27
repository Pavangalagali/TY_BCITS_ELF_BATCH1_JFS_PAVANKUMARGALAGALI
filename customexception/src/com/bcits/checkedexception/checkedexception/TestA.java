package com.bcits.checkedexception.checkedexception;

public class TestA {
	public static void main(String[] args) {

		Person p = new Person();

		System.out.println("---------------------------------------");
		try {
			p.clone();
			System.out.println("object cloned");
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("-----------------------------------------");
	}
}
