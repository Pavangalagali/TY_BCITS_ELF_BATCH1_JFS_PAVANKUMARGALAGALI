package com.bcits.collectioninterface.treeset;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet2 {

	public static void main(String[] args) {
		
		TreeSet<Person> ts = new TreeSet<Person>(new SortByName());
		ts.add(new Person("rahul", 26));
		ts.add(new Person("kiran", 19));
		ts.add(new Person("aryan", 20));
		ts.add(new Person("budda", 90));
		
		Iterator<Person> itr = ts.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
