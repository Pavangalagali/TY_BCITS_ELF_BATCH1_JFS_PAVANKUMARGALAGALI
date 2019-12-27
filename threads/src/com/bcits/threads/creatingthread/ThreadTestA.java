package com.bcits.threads.creatingthread;

public class ThreadTestA {
	public static void main(String[] args) {
		System.out.println("main started");
		Thread2 t1 = new Thread2();
		Thread2 t3 = new Thread2();
		Thread t2 = new Thread(t1);
		Thread t4 = new Thread(t3);
		t2.start();
		t4.start();
		System.out.println("main ended");
	}
}
