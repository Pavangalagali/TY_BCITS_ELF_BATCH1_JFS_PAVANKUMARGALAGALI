package com.javawork.second;

public class Mainclass2 {

	public static void main(String[] args) {
		
		Product p1 = new Product();
		p1.setBrand("samsung");
		p1.setCost(24000);
		p1.setName("Mobile");
		
		Product p2 = new Product();
		p2.setBrand("LG");
		p2.setCost(36000);
		p2.setName("Fridge");

		Product p3 = new Product();
		p3.setBrand("Apple");
		p3.setCost(54000);
		p3.setName("Mac Book");

		Product p4 = new Product();
		p4.setBrand("crompton");
		p4.setCost(900);
		p4.setName("fan");


		Product[] ob = {p1, p2, p3, p4};
		
		for (int i = 0; i < ob.length; i++) {
			
			System.out.println(ob[i]);
		}
	}

}
