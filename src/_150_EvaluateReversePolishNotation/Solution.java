package _150_EvaluateReversePolishNotation;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class Solution {
	public static void main(String[] args) {
		System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
	}

	public static int evalRPN(String[] tokens) {
		Deque<String> stack = new LinkedList<>();

		for (String s : tokens) {
			if (Objects.equals(s, "+")) {
				int i1 = Integer.parseInt(stack.pop());
				int i2 = Integer.parseInt(stack.pop());

				stack.push(String.valueOf(i2 + i1));
				continue;
			}
			if (Objects.equals(s, "-")) {
				int i1 = Integer.parseInt(stack.pop());
				int i2 = Integer.parseInt(stack.pop());

				stack.push(String.valueOf(i2 - i1));
				continue;
			}
			if (Objects.equals(s, "*")) {
				int i1 = Integer.parseInt(stack.pop());
				int i2 = Integer.parseInt(stack.pop());

				stack.push(String.valueOf(i2 * i1));
				continue;
			}
			if (Objects.equals(s, "/")) {
				int i1 = Integer.parseInt(stack.pop());
				int i2 = Integer.parseInt(stack.pop());

				stack.push(String.valueOf(i2 / i1));
				continue;
			}
			stack.push(s);
		}
		return Integer.parseInt(stack.pop());
	}
}
