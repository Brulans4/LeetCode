package _138_CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Integer> mapOldNodeIndex = new HashMap<>();
        Map<Integer, Node> mapIndexNewNode = new HashMap<>();

        Node currentNode = head;
        int i = 0;
        while (currentNode != null){
            mapOldNodeIndex.put(currentNode, i);
            mapIndexNewNode.put(i, new Node(currentNode.val));

            currentNode = currentNode.next;
            i ++;
        }
        Node newHead = mapIndexNewNode.get(0);

        currentNode = head;
        Node newCurrentNode = newHead;
        i = 0;

        while (currentNode != null){
            newCurrentNode.next = mapIndexNewNode.get(mapOldNodeIndex.get(currentNode.next));
            newCurrentNode.random = mapIndexNewNode.get(mapOldNodeIndex.get(currentNode.random));

            currentNode = currentNode.next;
            newCurrentNode = newCurrentNode.next;
            i ++;
        }
        return newHead;
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
