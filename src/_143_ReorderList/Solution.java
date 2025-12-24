package _143_ReorderList;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);

        int[] elts = new int[]{2, 0, -4};
        ListNode curretNode = head;
        for (int elt : elts) {
            curretNode.next = new ListNode(elt);
            curretNode = curretNode.next;
        }
        reorderList(head);
    }

    public static void reorderList(ListNode head) {
        Map<Integer, Integer> mapIndexNode = new HashMap<>();

        int index = 1;
        ListNode currentNode = head;
        currentNode = currentNode.next;

        while (currentNode != null) {
            mapIndexNode.put(index, currentNode.val);

            currentNode = currentNode.next;
            index++;
        }
        int left = 1;
        int right = index - 1;

        currentNode = head;
        while (!mapIndexNode.isEmpty()) {
            currentNode.next = new ListNode(mapIndexNode.remove(right));
            currentNode = currentNode.next;

            if (mapIndexNode.containsKey(left)) {
                currentNode.next = new ListNode(mapIndexNode.remove(left));
                currentNode = currentNode.next;
            }
            right--;
            left++;
        }
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
