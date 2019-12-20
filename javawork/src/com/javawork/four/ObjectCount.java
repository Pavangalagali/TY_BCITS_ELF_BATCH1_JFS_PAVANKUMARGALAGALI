package com.javawork.four;

public class ObjectCount {

	static int count = 0;
	
	public ObjectCount() {
		count++;
	}
	
	public static void main(String[] args) {
		
		new ObjectCount();
		new ObjectCount();
		new ObjectCount();
		new ObjectCount();
		new ObjectCount();
		
		System.out.println("number of objects created are..." + count);

	}

}
