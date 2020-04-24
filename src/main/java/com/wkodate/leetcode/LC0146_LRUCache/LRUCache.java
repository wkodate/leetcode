package com.wkodate.leetcode.LC0146_LRUCache;

import java.util.LinkedHashMap;

public class LRUCache {

    private int capacity;
    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() + 1 > capacity) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        // returns 1
        System.out.println(cache.get(1));
        cache.put(3, 3);
        // returns -1 (not found)
        System.out.println(cache.get(2));
        cache.put(4, 4);
        // returns -1 (not found)
        System.out.println(cache.get(1));
        // returns 3
        System.out.println(cache.get(3));
        // returns 4
        System.out.println(cache.get(4));

        System.out.println("\n");
        LRUCache cache2 = new LRUCache(2);
        // -1
        System.out.println(cache2.get(2));
        cache2.put(2, 6);
        // -1
        System.out.println(cache2.get(1));
        cache2.put(1, 5);
        cache2.put(1, 2);
        // 2
        System.out.println(cache2.get(1));
        // 6
        System.out.println(cache2.get(2));

        System.out.println("\n");
        LRUCache cache3 = new LRUCache(2);
        cache3.put(2, 1);
        cache3.put(1, 1);
        cache3.put(2, 3);
        cache3.put(4, 1);
        // -1
        System.out.println(cache3.get(1));
        // 3
        System.out.println(cache3.get(2));

        System.out.println("\n");
        LRUCache cache4 = new LRUCache(3);
        cache4.put(1, 1);
        cache4.put(2, 2);
        cache4.put(3, 3);
        cache4.put(4, 4);
        // 4
        System.out.println(cache4.get(4));
        // 3
        System.out.println(cache4.get(3));
        // 2
        System.out.println(cache4.get(2));
        // -1
        System.out.println(cache4.get(1));
        cache4.put(5, 5);
        // -1
        System.out.println(cache4.get(1));
        // 2
        System.out.println(cache4.get(2));
        // 3
        System.out.println(cache4.get(3));
        // -1
        System.out.println(cache4.get(4));
        // 5
        System.out.println(cache4.get(5));

    }

}
