package com.bcits.springcoreannotations;

import com.bcits.springcoreannotations.interfaces.Animal;

public class Goat implements Animal {

	@Override
	public void eat() {
		System.out.println("Eating Grass........");
	}

	@Override
	public void speak() {
		System.out.println("mehh! mehh!");
	}

}
