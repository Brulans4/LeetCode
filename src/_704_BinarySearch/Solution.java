package _704_BinarySearch;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};

        int res = search(nums, 9);
        if (res != 4) {
            System.out.println("Wrong answer, got: " + res + " (expected 4)");
        }
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int index = 0;

        while (left <= right) {
            index = (left + right) / 2;
            if (nums[index] == target) {
                return index;
            }

            if (nums[index] < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return -1;
    }
}
