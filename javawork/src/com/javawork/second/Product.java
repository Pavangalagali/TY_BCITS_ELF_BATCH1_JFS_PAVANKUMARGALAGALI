package com.javawork.second;

import java.io.Serializable;

public class Product implements Serializable {
	
	private String name;
	private double cost;
	private String brand;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", cost=" + cost + ", brand=" + brand + "]";
	}
	
	

}
