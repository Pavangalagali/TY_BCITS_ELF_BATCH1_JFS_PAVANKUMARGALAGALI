package org.bcits.collectioninterface.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class WaysToIterate {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(300);
		System.out.println(list);
		System.out.println("----------------using for loop--------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(" " + list.get(i));
		}
		System.out.println();
		System.out.println("----------------using for each loop------------------");
		for (Integer integer : list) {
			System.out.print(" " + integer);
		}
		System.out.println();
		System.out.println("----------------using iterator------------------");
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.print(" " + itr.next());
		}
		System.out.println();
		System.out.println("----------------using list iterator(forward)-------------");
		ListIterator<Integer> ltr = list.listIterator();
		while (ltr.hasNext()) {
			System.out.print(" " + ltr.next());
		}
		System.out.println();
		System.out.println("----------------using list iterator(backward)-------------");
		ListIterator<Integer> ltr1 = list.listIterator(list.size());
		while (ltr1.hasPrevious()) {
			System.out.print(" " + ltr1.previous());

		}

	}

}
