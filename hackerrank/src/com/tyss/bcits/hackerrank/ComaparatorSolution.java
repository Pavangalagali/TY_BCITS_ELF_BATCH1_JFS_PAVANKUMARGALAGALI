package com.tyss.bcits.hackerrank;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class ComaparatorSolution {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter the number of players");
		int n = Integer.parseInt(scanner.nextLine());
		TreeSet<Player> list = new TreeSet<Player>();

		for (int i = 1; i <= n; i++) {
			System.out.println("enter name and score");
			list.add(new Player(scanner.nextLine(), Integer.parseInt(scanner.nextLine())));
		}
		Iterator i1 = list.iterator();
		while (i1.hasNext()) {
			System.out.println(i1.next());
		}
		
		
	}

}
