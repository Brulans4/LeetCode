package _238_ProductOfArrayExceptSelf;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
		System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
		System.out.println(Arrays.toString(productExceptSelf(new int[]{0, 0})));
	}

	public static int[] productExceptSelf(int[] nums) {

		// nums{1, 2, 3, 4}
		int length = nums.length;
		int rightSide = 1;
		int leftSide = 1;

		// res{0, 0, 0, 0}
		int[] res = new int[length];

		for (int i = length - 1; i >= 0; i--) {
			res[i] = rightSide;
			rightSide *= nums[i];
		}
		// res{24, 12, 4, 1}

		for (int i = 0; i < length; i++) {
			res[i] *= leftSide;
			leftSide *= nums[i];
		}
		// res{24, 12, 8, 6}
		return res;
	}
}
