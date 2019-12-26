package org.bcits.collectioninterface.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayList1 {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		System.out.println("-----------------initial-------------------");
		System.out.println(list);
		System.out.println("-----------------add with idex-------------------");
		list.add(0, 90);
		list.add(1, 80);
		System.out.println(list);
		System.out.println("-----------------remove(index) and remove(object)-------------------");
		list.remove(3);
		list.remove(new Integer(80));
		System.out.println(list);
		System.out.println("-----------------set with idex and value-------------------");
		list.set(1, 20);
		list.set(2, 100);
		list.add(90);
		System.out.println(list);
		System.out.println("-----------------indexOf(Object()) and lastIndexOf(Object())-------------------");
		System.out.println(list.indexOf(90));
		System.out.println(list.lastIndexOf(90));
		System.out.println("-----------------get(index)-------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + " at index " + i);
		}
		List<Integer> list1 = list.subList(2, 5);
		System.out.println("-----------------subList()--------------");
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
	}

}
