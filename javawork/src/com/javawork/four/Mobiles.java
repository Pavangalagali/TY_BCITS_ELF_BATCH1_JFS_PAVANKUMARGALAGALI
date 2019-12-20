package com.javawork.four;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Mobiles {

	public static void main(String[] args) {
		
		Mobile m1 = new Mobile("mi", "note7", 8000);
		Mobile m2 = new Mobile("samsung", "galaxy Y", 10000);
		Mobile m3 = new Mobile("nokia", "1100", 1800);
		Mobile m4 = new Mobile("Apple", "Iphone xr", 82000);

		HashSet<Mobile> mlist = new  HashSet<Mobile>();
		
		mlist.add(m1);
		mlist.add(m2);
		mlist.add(m3);
		mlist.add(m4);
		
		Iterator<Mobile> i1 = mlist.iterator();
		
		while (i1.hasNext()) {
			
			System.out.println(i1.next());
			
		}
		
		
	}

}
