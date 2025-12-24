package _543_DiameterOfBinaryTree;

public class Solution {

    static int res = 0;

    public static void main(String[] args) {
        int i = diameterOfBinaryTree(new TreeNode(
            1,
            null,
            new TreeNode(
                3,
                new TreeNode(4, new TreeNode(6), null),
                new TreeNode(5, null, new TreeNode(9))
            )
        ));
        System.out.println(i);

        i = diameterOfBinaryTree(new TreeNode(
            1,
            null,
            new TreeNode(
                2
            )
        ));
        System.out.println(i);

        i = diameterOfBinaryTree(new TreeNode(
            1,
            new TreeNode(
                2
            ),
            null
        ));
        System.out.println(i);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        depth(root);

        return res;
    }

    private static int depth(TreeNode currentNode){
        if (currentNode == null){
            return 0;
        }
        int left = depth(currentNode.left);
        int right = depth(currentNode.right);

        res = Math.max(res, left + right);

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
