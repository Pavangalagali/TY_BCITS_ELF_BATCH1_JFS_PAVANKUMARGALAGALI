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
		int expressionCount = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= expressionCount; i++) {
			System.out.println("expression " + i);
			String expression = scanner.nextLine();
			if (isBalanced(expression)) {
				System.out.println(expression + "  is valid");
			} else {
				System.out.println(expression + "  is invalid");
			}
		}
	}
}
