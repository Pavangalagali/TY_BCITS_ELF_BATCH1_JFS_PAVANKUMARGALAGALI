package com.bcits.jdbcapp.common;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {

	public static void main(String[] args) {

		ArrayList<String> myData = new ArrayList<String>();
		myData.add("one");
		myData.add("two");
		myData.add("three");
		myData.add("four");
		myData.add("five");

		Iterator<String> itr = myData.iterator();

		while (itr.hasNext()) {
			String val = itr.next();
			System.out.println(val);
		}
	}

}
