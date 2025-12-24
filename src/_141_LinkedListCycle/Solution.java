package _141_LinkedListCycle;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);

        int[] elts = new int[]{2,0,-4};
        ListNode curretNode = head;
        for (int elt : elts) {
            curretNode.next = new ListNode(elt);
            curretNode = curretNode.next;
        }

        head.next.next.next.next = head.next;
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast != null && fast.equals(slow)){
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        return hasCycle2(head, set);
    }

    private static boolean hasCycle2(ListNode currentNode, Set<ListNode> set){
        if (currentNode == null){
            return false;
        }
        if (set.contains(currentNode)){
            return true;
        }
        set.add(currentNode);
        return hasCycle2(currentNode.next, set);
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
