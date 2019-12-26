package com.bcits.collectioninterface.vector;

import java.util.Vector;

public class Vector1 {

	public static void main(String[] args) {
		Vector<Integer> vl = new Vector<Integer>();
		System.out.println("initial values");
		vl.add(99);
		vl.add(null);
		vl.add(30);
		System.out.println(vl);
		System.out.println("------add(index,value)---------------------");
		vl.add(0, 20);
		vl.add(3, null);
		System.out.println(vl);
		System.out.println("---------remove()---------");
		vl.remove(3);
		System.out.println(vl);
		System.out.println("-----------setElementAt()------------");
		vl.setElementAt(100, 2);
		System.out.println(vl);
		System.out.println("---------------removeElement()--------------");
		vl.removeElementAt(0);
		System.out.println(vl);
		System.out.println("----------trimSize()------------");
		System.out.println(vl.size());
		vl.trimToSize();
		System.out.println(vl.size());
		System.out.println("------------------------------ensureCapacity()----------------");
		System.out.println(vl.size());
		vl.ensureCapacity(5);
		System.out.println(vl.size());
		System.out.println("----------------setSize()-------------------");
		System.out.println(vl.size());
		vl.setSize(10);
		System.out.println(vl.size());

	}

}
