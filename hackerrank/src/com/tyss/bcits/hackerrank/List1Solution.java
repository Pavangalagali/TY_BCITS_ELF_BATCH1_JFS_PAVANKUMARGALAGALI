package com.tyss.bcits.hackerrank;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class List1Solution {
	static Scanner scanner = new Scanner(System.in);
	static List<Integer> list = null;
	public static void main(String[] args) {
	System.out.println("enter the number of elements ..");
	int n = Integer.parseInt(scanner.nextLine());
	list = new ArrayList<Integer>(n);
	System.out.println("enter the elements.....");
	for (int i = 0; i < n; i++) {
		System.out.println("enter the elemrnt for "+ i + " index");
		list.add(i, Integer.parseInt(scanner.nextLine()));
	}
	System.out.println(list);
	System.out.println("enter the number of query..");
	int q = Integer.parseInt(scanner.nextLine());
	for (int i = 1; i <= q; i++) {
		System.out.println("query : " + (i));
		System.out.println("enter the query type insert/delete");
		String query = scanner.nextLine().toLowerCase();
		switch(query) {
		case "insert" : System.out.println("enter the index for insertion");
						int x = Integer.parseInt(scanner.nextLine());
						System.out.println("enter the value to insert");
						int y = Integer.parseInt(scanner.nextLine());
						list.add(x, y);
						n++;
						break;
		case "delete" : System.out.println("enter the index for deletion");
						int index = Integer.parseInt(scanner.nextLine());
						list.remove(index);
						n--;
						break;
		default :
			System.out.println("invalid query.......");
			break;
		}
	}
	System.out.println(list);
	scanner.close();
	}

}
