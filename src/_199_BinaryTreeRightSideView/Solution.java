package _199_BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightSideView(root, 1,  list);
        return list;
    }

    private void rightSideView(TreeNode currentNode, int currentLvl, List<Integer> list) {
        if (currentNode == null){
            return;
        }

        while (list.size() < currentLvl){
            list.add(null);
        }

        if (list.get(currentLvl - 1) == null){
            list.set(currentLvl - 1, currentNode.val);
        }
        rightSideView(currentNode.right, currentLvl + 1, list);
        rightSideView(currentNode.left, currentLvl + 1, list);
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
