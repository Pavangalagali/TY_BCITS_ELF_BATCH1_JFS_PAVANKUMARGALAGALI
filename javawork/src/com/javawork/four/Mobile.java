package com.javawork.four;

public class Mobile implements Comparable<Mobile>{

	String  brand;
	String model;
	double price;
	
	public Mobile(String brand, String model, double price) {
		super();
		this.brand = brand;
		this.model = model;
		this.price = price;
	}

	@Override
	public int hashCode() {
		return (int) price;
	}

	@Override
	public String toString() {
		return "Mobile [brand=" + brand + ", model=" + model + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Mobile o) {
		
		return this.hashCode()-o.hashCode();
	}
	
}
