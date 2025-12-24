package _11_ContainerWithMostWater;

public class Solution {
	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
		System.out.println();
		System.out.println(maxArea(new int[]{1, 1}));
		System.out.println();
		System.out.println(maxArea(new int[]{1, 2, 4, 3}));
		System.out.println();
		System.out.println(maxArea(new int[]{1, 2}));

	}

	public static int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;

		int max = 0;

		while (left < right) {
			int leftHeight = height[left];
			int rightHeight = height[right];

			if (leftHeight < rightHeight) {
				int tmp = leftHeight * (right - left);

				if (max < tmp) {
					max = tmp;
				}
			} else {
				int tmp = rightHeight * (right - left);

				if (max < tmp) {
					max = tmp;
				}
			}

			if (leftHeight < rightHeight) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}
}
