package com.javawork.four;

import java.util.ArrayList;

import com.javawork.second.Product;

public class ProductDeatails {

	public static void main(String[] args) {
		
		Product p1 = new Product();
		p1.setBrand("samsung");
		p1.setCost(24000);
		p1.setName("Mobile");
		
		Product p2 = new Product();
		p2.setBrand("LG");
		p2.setCost(1000);
		p2.setName("Fridge");

		Product p3 = new Product();
		p3.setBrand("Apple");
		p3.setCost(54000);
		p3.setName("Mac Book");

		Product p4 = new Product();
		p4.setBrand("crompton");
		p4.setCost(900);
		p4.setName("fan");
		
		Product p5 = new Product();
		p5.setBrand("classmate");
		p5.setCost(150);
		p5.setName("book");
		
		ArrayList<Product> plist = new ArrayList<Product>();
		
		plist.add(p1);
		plist.add(p2);
		plist.add(p3);
		plist.add(p4);
		plist.add(p5);
		
		int i=0;
		while(i < plist.size()) {
			
			if((plist.get(i).getCost()) < 2000) {
				
				System.out.println(plist.get(i));
			}
			i++;
		}
		
		
		

	}

}
