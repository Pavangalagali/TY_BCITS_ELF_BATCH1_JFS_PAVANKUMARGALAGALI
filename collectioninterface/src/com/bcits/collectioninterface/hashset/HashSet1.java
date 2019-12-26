package com.bcits.collectioninterface.hashset;

import java.util.HashSet;

public class HashSet1 {

	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(100);
		hs.add(null);
		hs.add(200);
		hs.add(50);
		hs.add(25);
		System.out.println(hs);
		hs.remove(50);
		System.out.println(hs);
		hs.remove(null);
		System.out.println(hs);
	}

}
