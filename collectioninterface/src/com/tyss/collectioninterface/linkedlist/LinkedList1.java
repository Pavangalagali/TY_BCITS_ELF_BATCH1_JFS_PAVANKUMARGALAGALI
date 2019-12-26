package com.tyss.collectioninterface.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class LinkedList1 {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(90);
		list.add(30);
		System.out.println(list);
		System.out.println("-----------------add with idex-------------------");
		list.add(0, 100);
		list.add(1, 80);
		System.out.println(list);
		System.out.println("-----------------remove(index) and remove(object)-------------------");
		list.remove(3);
		list.remove(new Integer(80));
		System.out.println(list);
		System.out.println("--------------set at index ------------------------");
		list.set(1, 77);
		System.out.println(list);
		list.add(30);
		list.add(1, 80);
		System.out.println("--------------containsall-----------");
		LinkedList<Integer> ls = new LinkedList<Integer>();
		ls.add(100);
		ls.add(30);
		System.out.println(ls);
		System.out.println(list);
		System.out.println(list.containsAll(ls));
		list.addLast(100);
		System.out.println("-----------------indexOf(Object()) and lastIndexOf(Object())-------------------");
		System.out.println(list);
		System.out.println(list.indexOf(100));
		System.out.println(list.lastIndexOf(100));
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
