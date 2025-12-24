package _167_TwoSum2InputArrayIsSorted;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
		System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
		System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1)));
	}

	public static int[] twoSum(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;

		while (numbers[left] + numbers[right] != target) {
			if (numbers[left] + numbers[right] > target) {
				right--;
			} else {
				left++;
			}
		}
		return new int[]{left + 1, right + 1};
	}
}
