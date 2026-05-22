package _230_KthSmallestElementInABST;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.PriorityQueue;

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
        System.out.println(kthSmallest(
            new TreeNode(
                3, new TreeNode(
                1, null, new TreeNode(2)
            ), new TreeNode(4)
            ), 1));

        System.out.println(kthSmallest(
            new TreeNode(
                3, new TreeNode(
                1, null, new TreeNode(2)
            ), new TreeNode(4)
            ), 4));
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        findKthSmallest(root, list);

        return list.get(k - 1);
    }

    private static void findKthSmallest(TreeNode currentNode, List<Integer> list) {
        if (currentNode == null) {
            return;
        }
        findKthSmallest(currentNode.left, list);
        list.add(currentNode.val);
        findKthSmallest(currentNode.right, list);
    }

    public static int kthSmallestNlogN(TreeNode root, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        fillHeap(root, heap);

        for (int i = 0; i < k - 1; i++) {
            heap.poll();
        }
        return heap.poll();
    }

    private static void fillHeap(TreeNode currentNode, PriorityQueue<Integer> heap) {
        if (currentNode == null) {
            return;
        }
        heap.add(currentNode.val);

        fillHeap(currentNode.left, heap);
        fillHeap(currentNode.right, heap);
    }
}
