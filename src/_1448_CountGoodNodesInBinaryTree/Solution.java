package _1448_CountGoodNodesInBinaryTree;

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
        TreeNode tree = new TreeNode(3,
            new TreeNode(1,
                new TreeNode(3),
                null),
            new TreeNode(4,
                new TreeNode(1),
                new TreeNode(5)
            )
        );
        System.out.println(goodNodes(tree));
    }

    public static int goodNodes(TreeNode root) {
        return goodNodes(root.val, root.left) +
            goodNodes(root.val, root.right) + 1;
    }

    private static int goodNodes(int max, TreeNode currentNode) {
        if (currentNode == null) {
            return 0;
        }
        if (max <= currentNode.val) {
            return goodNodes(currentNode.val, currentNode.left) +
                goodNodes(currentNode.val, currentNode.right) + 1;
        }
        return goodNodes(max, currentNode.left) +
            goodNodes(max, currentNode.right);
    }
}
