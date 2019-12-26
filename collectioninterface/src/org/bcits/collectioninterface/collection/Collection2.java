package org.bcits.collectioninterface.collection;

import java.util.ArrayList;
import java.util.Collection;

public class Collection2 {

	public static void main(String[] args) {
		Collection<Integer> c1 = new ArrayList<Integer>();
		c1.add(10);
		c1.add(20);
		c1.add(30);
		c1.add(40);
		Collection<Integer> c2 = new ArrayList<Integer>();
		c2.add(90);
		c2.add(80);
		c2.add(20);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println("------------------------");
		c1.addAll(c2);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println("------------------------");
		c1.removeAll(c2);
		System.out.println(c1);
		System.out.println(c2);

		System.out.println("-------------- containall() and retaiall()---------------------------");
		Collection<Integer> c3 = new ArrayList<Integer>();
		c3.add(10);
		c3.add(20);
		c3.add(80);
		c3.add(40);
		Collection<Integer> c4 = new ArrayList<Integer>();
		c4.add(90);
		c4.add(80);
		c4.add(20);
		System.out.println("------------------------");
		System.out.println(c3);
		System.out.println(c4);

		System.out.println(c4.containsAll(c3));
		c4.retainAll(c3);
		System.out.println("------------------------");
		System.out.println(c3);
		System.out.println(c4);
		System.out.println("-------------toArray()---------------");

		Object[] o1 = c3.toArray();
		for (int i = 0; i < o1.length; i++) {
			System.out.println(o1[i] + " at " + i);
		}

	}

}
