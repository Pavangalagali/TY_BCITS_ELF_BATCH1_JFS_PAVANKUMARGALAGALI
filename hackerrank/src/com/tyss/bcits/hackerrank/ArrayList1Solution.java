package com.tyss.bcits.hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList1Solution {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the number of lines...");
		int n = scanner.nextInt();
		ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>(n);
		ArrayList<Integer> arrayList = null;

		for (int i = 1; i <= n; i++) {
			System.out.println("enter the number of digits for " + i + "th line");
			int d = scanner.nextInt();
			arrayList = new ArrayList<Integer>(d);
			arrayList.add(0, d);
			for (int j = 1; j <= d; j++) {
				System.out.println("enter the element at " + j + " th position");
				arrayList.add(j, scanner.nextInt());

			}
			System.out.println(arrayList.toString());
			arrayLists.add(arrayList);
		}
		System.out.println(arrayLists.toString());
		System.out.println("enter the number of quries");
		int q = scanner.nextInt();
		for (int i = 1; i <= q; i++) {

			System.out.println("query : " + i);
			System.out.println("enter the line number");
			int x = scanner.nextInt();
			if (x > n) {
				System.err.println("error...");
				continue;
			}
			System.out.println(arrayLists.get(x - 1));
			System.out.println("enter the position");
			int y = scanner.nextInt();
			if (y > arrayList.size() + 1) {
				System.err.println("error.....");
				return;
			}
			System.out.println(arrayLists.get(x - 1).get(y));

		}

		scanner.close();

	}
}
