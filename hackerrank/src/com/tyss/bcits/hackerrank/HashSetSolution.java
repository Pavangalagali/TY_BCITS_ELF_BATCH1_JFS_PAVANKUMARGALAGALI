package com.tyss.bcits.hackerrank;

import java.util.HashSet;
import java.util.Scanner;

public class HashSetSolution {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("how many pairs to insert");
		int pairs = Integer.parseInt(scanner.nextLine());
		HashSet<String> set = new HashSet<String>();
		for (int i = 1; i <= pairs; i++) {
			System.out.println("pair : " + i);
			System.out.println("enter the first value and second value");
			String first = scanner.nextLine();
			String second = scanner.nextLine();
			set.add(first + " " + second);
			System.out.println("number of unique pairs in set : " + set.size());

		}
		scanner.close();
	}

}
