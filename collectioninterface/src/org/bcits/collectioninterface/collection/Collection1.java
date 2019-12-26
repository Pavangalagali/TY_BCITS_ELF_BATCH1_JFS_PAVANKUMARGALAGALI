package org.bcits.collectioninterface.collection;

import java.util.ArrayList;
import java.util.Collection;

public class Collection1 {
	public static void main(String[] args) {
		Collection<Integer> c1 = new ArrayList<Integer>();
		c1.add(10);
		c1.add(20);
		c1.add(30);
		System.out.println(c1);
		c1.remove(20);
		System.out.println(c1);
		System.out.println(c1.isEmpty());
		System.out.println(c1.contains(10));
		System.out.println(c1.size());
	}
}
