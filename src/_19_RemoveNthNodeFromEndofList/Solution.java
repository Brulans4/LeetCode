package _19_RemoveNthNodeFromEndofList;

import _141_LinkedListCycle.Solution.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);

        int[] elts = new int[]{2, 0, -4};
        ListNode currentNode = head;
        for (int elt : elts) {
            currentNode.next = new ListNode(elt);
            currentNode = currentNode.next;
        }
        currentNode = removeNthFromEnd(head, 1);
        while (currentNode != null){
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }

        int size = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }

        if (size == n){
            return head.next;
        }
        int indexRemove = size - n;

        currentNode = head;
        for (int i = 0; i < indexRemove-1; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
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
