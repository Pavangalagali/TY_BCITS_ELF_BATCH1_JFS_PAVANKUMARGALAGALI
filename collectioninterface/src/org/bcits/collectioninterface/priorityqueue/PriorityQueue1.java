package org.bcits.collectioninterface.priorityqueue;

import java.util.PriorityQueue;

public class PriorityQueue1 {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(88);
		pq.add(88);
		pq.add(88);
		pq.add(1);
		pq.add(29);
		pq.add(0);
		System.out.println(pq);
		pq.remove();
		System.out.println(pq);
		pq.remove();
		System.out.println(pq);
	}

}
