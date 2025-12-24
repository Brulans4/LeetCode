package _25_ReverseNodesInKGroup;

public class Solution {

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

    public static void main(String[] args) {
        ListNode res = reverseKGroup(new ListNode(1, new ListNode(4, new ListNode(5, new ListNode(-3, new ListNode(-6))))), 2);

        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1){
            return head;
        }

        int size = getSize(head);
        int rest = size % k;

        int reverseSize = size - rest;

        ListNode currentNode = head.next;
        ListNode newHead = new ListNode(head.val);

        ListNode listKNode = newHead;
        ListNode prevListKNode = null;

        int i = 1;
        while (currentNode != null) {
            if (reverseSize <= i){
                break;
            }

            ListNode newNode = new ListNode(currentNode.val);
            newNode.next = listKNode;

            listKNode = newNode;
            currentNode = currentNode.next;
            i ++;

            if (i % k == 0){
                if (prevListKNode == null){
                    newHead = listKNode;
                    prevListKNode = getEnd(listKNode);
                    listKNode = null;
                }
                else {
                    prevListKNode.next = listKNode;
                    prevListKNode = getEnd(listKNode);
                    listKNode = null;
                }
            }
        }
        while (currentNode != null) {
            prevListKNode.next = new ListNode(currentNode.val);
            prevListKNode = prevListKNode.next;
            currentNode = currentNode.next;
        }

        return newHead;
    }

    private static ListNode getEnd(ListNode listNode) {
        if (listNode == null){
            return null;
        }

        while (listNode.next != null){
            listNode = listNode.next;
        }
        return listNode;
    }

    private static int getSize(ListNode head) {
        int size = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }
}
