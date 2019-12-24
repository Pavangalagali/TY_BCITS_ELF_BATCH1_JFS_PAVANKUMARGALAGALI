package com.tyss.bcits.hackerrank;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HashMap1Solution {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("number of entries to the phonebook");
		int n = Integer.parseInt(scanner.nextLine());

		HashMap<String, Long> map = new HashMap<String, Long>(n);

		for (int i = 1; i <= n; i++) {
			System.out.println(i + ": enter the  details name and number ");
			String name = scanner.nextLine();
			long phoneno = Long.parseLong(scanner.nextLine());
			map.put(name, phoneno);
		}

		Set<String> keys = map.keySet();

		System.out.println("enter the number of quries...");
		int q = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < q; i++) {
			System.out.println("enter the name");
			String find = scanner.nextLine();
			if (map.get(find) != null) {
				System.out.println("number found.....");
				System.out.println(find + " " + map.get(find));
			} else {
				System.err.println("number not found");
			}
		}
		scanner.close();
	}
	

}
