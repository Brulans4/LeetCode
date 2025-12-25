package _235_LowestCommonAncestorOfABinarySearchTree;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (q.val < p.val){
            return lowestCommonAncestor(root, q, p);
        }

        if (p.val <= root.val && root.val <= q.val){
            return root;
        }

        if (root.val < p.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
