package com.bcits.collectioninterface.linkedhaslhset;

import java.util.LinkedHashSet;

public class LinkedHashSet1 {

	public static void main(String[] args) {

		LinkedHashSet<Integer> hs = new LinkedHashSet<Integer>();
		hs.add(100);
		hs.add(200);
		hs.add(50);
		hs.add(25);
		System.out.println(hs);
		hs.remove(50);

	}

}
