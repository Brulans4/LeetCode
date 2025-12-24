package _23_MergekSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{
            new ListNode(1, new ListNode(4, new ListNode(5))),
            new ListNode(1, new ListNode(3, new ListNode(4))),
            new ListNode(2, new ListNode(6))
        };
        ListNode res = mergeKLists(lists);

        ListNode currentNode = res;
        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });


        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        ListNode minNode = minHeap.poll();
        if (minNode == null){
            return null;
        }

        ListNode head = new ListNode(minNode.val);
        if (minNode.next != null) {
            minHeap.add(minNode.next);
        }

        ListNode currentNode = head;
        while (!minHeap.isEmpty()) {
            minNode = minHeap.poll();
            currentNode.next = new ListNode(minNode.val);

            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }
            currentNode = currentNode.next;
        }
        return head;
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
