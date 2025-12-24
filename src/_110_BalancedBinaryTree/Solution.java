package _110_BalancedBinaryTree;

public class Solution {

    public static void main(String[] args) {
        System.out.println( isBalanced(null) + " expected (true)");
        System.out.println( isBalanced(new TreeNode(3)) + " expected (true)");
        System.out.println( isBalanced(new TreeNode(3, new TreeNode(2), null)) + " expected (true)");
        System.out.println( isBalanced(new TreeNode(3, new TreeNode(2, new TreeNode(1), null), null)) + " expected (false)");
    }

    static boolean res = true;

    public static boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        res = true;
        depth(root);
        return res;
    }

    public static int depth(TreeNode currentNode){
       if (currentNode == null){
           return 0;
       }
       int left = depth(currentNode.left);
       int right = depth(currentNode.right);

       if (left < right - 1 || right + 1 < left){
           res = false;
       }

       return Math.max(left, right) + 1;
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
