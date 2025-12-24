package _128_LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
		System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
		System.out.println(longestConsecutive(new int[]{0, -1}));
	}

	public static int longestConsecutive(int[] nums) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();

		for (int num : nums) {
			set1.add(num);
		}

		int max = 0;

		for (int num1 : set1) {
			if (!set2.contains(num1)) {
				int num2 = num1 + 1;
				int count = 0;

				while (set1.contains(num1)) {
					set2.add(num1);

					num1--;
					count++;
				}

				while (set1.contains(num2)) {
					set2.add(num2);

					count++;
					num2++;
				}

				if (max < count) {
					max = count;
				}
			}
		}
		return max;
	}
}
