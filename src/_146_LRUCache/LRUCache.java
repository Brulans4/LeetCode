package _146_LRUCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache {

    private class Node{
        int key;
        int val;

        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return key == node.key && val == node.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }

    int capacity;
    Map<Integer, Node> mapKeyNode;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        mapKeyNode = new HashMap<>();
    }

    public int get(int key) {
        if (mapKeyNode.containsKey(key)){
            Node targetNode = mapKeyNode.get(key);
            if(mapKeyNode.size() == 1){
                return head.val;
            }
            if (head.equals(targetNode)){
                return head.val;
            }
            if (tail.equals(targetNode)){
                Node prevNode = targetNode.prev;
                prevNode.next = null;
                tail = prevNode;

                targetNode.prev = null;
                targetNode.next = head;
                head.prev = targetNode;
                head = targetNode;

                return head.val;
            }
            Node prevNode = targetNode.prev;
            Node nextNode = targetNode.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            targetNode.prev = null;
            targetNode.next = head;
            head.prev = targetNode;
            head = targetNode;

            return head.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (head == null){
            head = new Node(key, value);
            tail = head;

            mapKeyNode.put(key, head);
            return;
        }
        if (head.key == key){
            head.val = value;
            mapKeyNode.put(key, head);
            return;
        }
        if (tail.key == key){
            Node newTail = tail.prev;
            newTail.next = null;
            tail.prev = null;

            tail.next = head;
            head.prev = tail;
            head = tail;
            tail = newTail;

            head.val = value;
            mapKeyNode.put(key, head);
            return;
        }
        if (mapKeyNode.containsKey(key)) {
            Node currentNode = mapKeyNode.get(key);

            Node prevNode = currentNode.prev;
            Node nextNode = currentNode.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            currentNode.prev = null;
            currentNode.next = head;
            head.prev = currentNode;
            head = currentNode;

            head.val = value;
            mapKeyNode.put(key, head);
            return;
        }

        if (mapKeyNode.size() < capacity){
            Node newHead = new Node(key, value);

            newHead.next = head;
            head.prev = newHead;
            head = newHead;

            mapKeyNode.put(key, head);
            return;
        }
        Node newHead = new Node(key, value);

        newHead.next = head;
        head.prev = newHead;
        head = newHead;

        mapKeyNode.put(key, head);

        Node oldTail = tail;
        Node newTail = oldTail.prev;
        oldTail.prev = null;
        newTail.next = null;
        tail = newTail;

        mapKeyNode.remove(oldTail.key);
    }
}
