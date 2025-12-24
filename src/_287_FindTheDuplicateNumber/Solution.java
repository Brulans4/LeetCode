package _287_FindTheDuplicateNumber;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));

        nums = new int[]{3, 3, 3, 3, 3};
        System.out.println(findDuplicate(nums));

        nums = new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int indexFast = 0;
        int indexSlow = 0;

        while (true) {
            indexSlow = nums[indexSlow];
            indexFast = nums[nums[indexFast]];

            if (indexSlow == indexFast) {
                break;
            }
        }
        int indexNewSlow = 0;

        while (true) {
            indexSlow = nums[indexSlow];
            indexNewSlow = nums[indexNewSlow];

            if (indexSlow == indexNewSlow) {
                return indexNewSlow;
            }
        }
    }
}
