package _146_LRUCache;

public class Solution {

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(2, 1);
        obj.put(1, 1);
        System.out.println(obj.get(2));
        obj.put(4, 1);
        System.out.println(obj.get(1));
        System.out.println(obj.get(2));
    }

}
