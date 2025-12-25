package _102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        levelOrder(root, list, 1);
        return list;
    }

    private void levelOrder(TreeNode currentNode, List<List<Integer>> list, int currentHeight) {
        if (currentNode == null){
            return;
        }

        if (list.size() < currentHeight) {
            list.add(new ArrayList<>());
        }
        list.get(currentHeight - 1).add(currentNode.val);

        levelOrder(currentNode.left, list, currentHeight + 1);
        levelOrder(currentNode.right, list, currentHeight + 1);
    }

    public class TreeNode {

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
