package _739_DailyTemperatures;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
		System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 40, 50, 60})));
		System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 60, 90})));
	}

	public static int[] dailyTemperatures(int[] temperatures) {
		Deque<Integer> stack = new LinkedList<>();
		int length = temperatures.length;
		int[] res = new int[length];

		for (int i = length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
				stack.pop();
			}

			if (!stack.isEmpty()) {
				res[i] = stack.peek() - i;
			}
			stack.push(i);
		}
		return res;
	}
}
