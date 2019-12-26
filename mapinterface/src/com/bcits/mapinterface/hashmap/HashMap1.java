package com.bcits.mapinterface.hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMap1 {

	public static void main(String[] args) {
		HashMap<String, Integer> h1 = new HashMap<String, Integer>();

		h1.put("me", 22);
		h1.put("you", 12);
		h1.put("no", 99);

		Set<Map.Entry<String, Integer>> m1 = h1.entrySet();
		for (Map.Entry<String, Integer> entry : m1) {
			System.out.print(entry.getKey() + " = ");
			System.out.println(entry.getValue());
			System.out.println("--------------------------------");
		}
		Collection<String> s1 = h1.keySet();
		for (String string : s1) {
			System.out.println(string);
		}
		Collection<Integer> s2 =  h1.values();
		for (Integer integer : s2) {
			System.out.println(integer);
		}
	}

}
