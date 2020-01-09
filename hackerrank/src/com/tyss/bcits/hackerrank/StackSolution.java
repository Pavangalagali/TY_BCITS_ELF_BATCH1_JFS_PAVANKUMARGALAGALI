package com.tyss.bcits.hackerrank;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class StackSolution {

	static HashMap<Character, Character> bMap;

	static {
		bMap = new HashMap<>();
		bMap.put('(', ')');
		bMap.put('[', ']');
		bMap.put('{', '}');
	}

	static boolean isBalanced(String str) {

		if ((str.length() % 2) != 0) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			if (bMap.containsKey(ch)) {
				stack.push(ch);
			} else if (stack.isEmpty() || ch != bMap.get(stack.pop())) {
				return false;
			}
		}

		return stack.isEmpty() ? true : false;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("number of expression");
		int t = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= t; i++) {
			System.out.println("expression " + i);
			String s = scanner.nextLine();
			if (isBalanced(s)) {
				System.out.println(s + "  is valid");
			} else {
				System.out.println(s + "  is invalid");
			}
		}
	}
}
