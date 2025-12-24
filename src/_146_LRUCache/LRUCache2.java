package _146_LRUCache;

public class LRUCache2 {

    int capacity;
    int listSize;
    Node head;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        listSize = 0;
        head = null;
    }

    public int get(int key) {
        if (head == null){
            return -1;
        }
        if (head.key == key){
            return head.value;
        }
        Node currentNode = head;

        while (currentNode.next != null) {
            if (currentNode.next.key == key) {
                Node newHead = currentNode.next;

                currentNode.next = currentNode.next.next;

                newHead.next = head;
                head = newHead;

                return head.value;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (head == null){
            head = new Node(key, value);
            listSize ++;
            return;
        }
        if (head.key == key){
            head.value = value;
            return;
        }
        Node prevKeyNode = getNode(key);
        if (prevKeyNode != null) {
            prevKeyNode.next = prevKeyNode.next.next;

            Node newHead = new Node(key, value);
            newHead.next = head;
            head = newHead;
            return;
        }
        if (listSize < capacity) {
            Node newHead = new Node(key, value);
            newHead.next = head;
            head = newHead;

            listSize ++;
            return;
        }
        Node newHead = new Node(key, value);
        newHead.next = head;
        head = newHead;

        removeLast();
    }

    private void removeLast() {
        Node currentNode = head;
        if (currentNode == null){
            return;
        }
        while (currentNode.next != null){
            if (currentNode.next.next == null){
                currentNode.next = null;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    private Node getNode(int key) {
        Node currentNode = head;

        if (currentNode == null) {
            return null;
        }

        while (currentNode.next != null) {
            if (currentNode.next.key == key) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    private class Node {

        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
