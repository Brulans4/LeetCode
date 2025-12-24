package _1_TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) {
		Arrays.stream(twoSum(new int[]{2,7,11,15}, 9)).forEach(i -> System.out.print(i + ", "));
		System.out.println();
		Arrays.stream(twoSum(new int[]{3,2,4}, 6)).forEach(i -> System.out.print(i + ", "));
		System.out.println();
		Arrays.stream(twoSum(new int[]{3,3}, 6)).forEach(i -> System.out.print(i + ", "));
		System.out.println();

	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] res = new int[2];

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target-nums[i])){
				res[0] = map.get(target-nums[i]);
				res[1] = i;
				break;
			}
			map.put(nums[i], i);
		}
		return res;
	}
}
