package _15_3Sum;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
		System.out.println();
		System.out.println(threeSum(new int[]{0, 1, 1}));
		System.out.println();
		System.out.println(threeSum(new int[]{0, 0, 0}));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> lists = new LinkedList<>();
		Set<List<Integer>> set = new HashSet<>();

		Arrays.sort(nums);


		for (int i = 0; i < nums.length; i++) {

			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];

				if (sum == 0) {
					List<Integer> list = new LinkedList<>();

					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);

					if (set.add(list)) {
						lists.add(list);
					}
					j++;
					k--;
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return lists;
	}
}
