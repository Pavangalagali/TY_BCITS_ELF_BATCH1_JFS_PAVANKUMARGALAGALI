package com.javawork.third;

public class Car {
   
	Fuel f1;

	public Car(Fuel f1) {
		super();
		this.f1 = f1;
	}

	public Car() {
		super();
	}

	@Override
	public String toString() {
		return "Car has " + f1;
	}
	
	
}
