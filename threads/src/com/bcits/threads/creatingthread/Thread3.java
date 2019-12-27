package com.bcits.threads.creatingthread;

public class Thread3 extends Thread {
	@Override
	public synchronized void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println(i);
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	 public synchronized void leaveMe() {
		System.out.println("nofify");
		notifyAll();
	}
}
