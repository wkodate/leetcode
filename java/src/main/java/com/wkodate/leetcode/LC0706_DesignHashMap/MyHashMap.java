package com.wkodate.leetcode.LC0706_DesignHashMap;


public class MyHashMap {

    class ListNode {
        private int key;
        private int val;
        private ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    private ListNode[] nodes;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        this.nodes = new ListNode[1000000];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int i = idx(key);
        ListNode prev = findNode(i, key);
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.val = value;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int i = idx(key);
        ListNode prev = findNode(i, key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.val;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int i = idx(key);
        ListNode prev = findNode(i, key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    private int idx(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    private ListNode findNode(int idx, int key) {
        if (nodes[idx] == null) {
            return nodes[idx] = new ListNode(-1, -1);
        }
        ListNode prev = nodes[idx];
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        // 1
        System.out.println(hashMap.get(1));
        // -1
        System.out.println(hashMap.get(3));
        hashMap.put(2, 1);
        // 1
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        // -1
        System.out.println(hashMap.get(2));
    }

}
