package _98_ValidateBinarySearchTree;

public class Solution {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
        System.out.println(isValidBST(new TreeNode(Integer.MIN_VALUE, null, new TreeNode(Integer.MAX_VALUE))));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root.left, Long.MIN_VALUE, root.val) && isValidBST(root.right, root.val, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null){
            return true;
        }

        if ( min < root.val && root.val < max){
            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
        }
        return false;
    }
}
