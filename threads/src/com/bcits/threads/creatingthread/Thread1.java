package com.bcits.threads.creatingthread;

public class Thread1 extends Thread {
	@Override
	public void run() {
		System.out.println("thread is called ");
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
