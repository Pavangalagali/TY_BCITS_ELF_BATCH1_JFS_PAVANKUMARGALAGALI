package com.tyss.bcits.hackerrank;

import java.util.Comparator;

public class SortByScore implements Comparator<Player>{

	@Override
	public int compare(Player o1, Player o2) {
		if(o1.hashCode()==o2.hashCode()) {
		return	o1.name.compareTo(o2.name);
		}
		return o1.hashCode()-o2.hashCode();
	} 

}
