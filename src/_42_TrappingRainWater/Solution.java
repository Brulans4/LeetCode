package _42_TrappingRainWater;

public class Solution {
	public static void main(String[] args) {
		System.out.println("rep: 6 => " + trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
		System.out.println("--------------------");
		System.out.println("rep: 9 => " + trap(new int[]{4, 2, 0, 3, 2, 5}));
		System.out.println("--------------------");
		System.out.println("rep: 9 => " + trap(new int[]{2, 1, 0, 3, 0, 3, 0, 1, 2}));
		System.out.println("--------------------");

		System.out.println("rep: 0 => " + trap(new int[]{1, 1}));
		System.out.println("--------------------");
		System.out.println("rep: 1 => " + trap(new int[]{1, 0, 1}));
		System.out.println("--------------------");
		System.out.println("rep: 2 => " + trap(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
		System.out.println("--------------------");
	}

	public static int trap(int[] height) {
		int leftIndex = 0;
		int rightIndex = height.length - 1;

		int leftCurrentMax = height[leftIndex];
		int rightCurrentMax = height[rightIndex];

		int water = 0;

		while (leftIndex <= rightIndex) {
			if (leftCurrentMax < rightCurrentMax) {
				if (leftCurrentMax < height[leftIndex]) {
					leftCurrentMax = height[leftIndex];
				}
				water += leftCurrentMax - height[leftIndex];
				leftIndex++;
			}

			else {
				if (rightCurrentMax < height[rightIndex]) {
					rightCurrentMax = height[rightIndex];
				}
				water += rightCurrentMax - height[rightIndex];
				rightIndex--;
			}
		}
		return water;
	}
}
