package com.javawork.third;

import java.util.Scanner;

public class MainClass {
	/*
	 * creating instanceof  of icecream class with flavour;
	 * passing the that instance to baby class;
	 * 
	 * creating instance of gift providing giftname;
	 * passing the gift to Friend class;
	 */

	public static void main(String[] args) {
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("which flavour you like........?");
		
		IceCream flavour1 = new IceCream(sc1.nextLine());
		Baby b1 = new Baby();
        
		 b1.receive(flavour1);
		 
		 System.out.println("whom do you want to gift..");
		 String name= sc1.nextLine();
		 System.out.println("which gift u want to present..");
		 
		 Gift g1 = new Gift(sc1.nextLine());
		 Friend friend1 = new Friend();
		 friend1.receive(g1, name);
		 
		 System.out.println(friend1);
	}

}
