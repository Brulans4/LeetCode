package _104_MaximumDepthOfBinaryTree;

public class Solution {

    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depthLeft = maxDepth(root.left);
        int depthRight = maxDepth(root.right);

        return Math.max(depthLeft, depthRight) + 1;
    }

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
}
