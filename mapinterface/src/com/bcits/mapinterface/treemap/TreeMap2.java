package com.bcits.mapinterface.treemap;

import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TreeMap2 {

	public static void main(String[] args) {

		TreeMap<Student, Integer> s1 = new TreeMap<Student, Integer>(new SortById());
		s1.put(new Student("me", 9), 12);
		s1.put(new Student("you", 8), 13);
		s1.put(new Student("nobody", 1), 11);
		Set<Entry<Student, Integer>> mp = s1.entrySet();
		for (Entry<Student, Integer> entry : mp) {
			System.out.println(entry);

		}
	}
}
