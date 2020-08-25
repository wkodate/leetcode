package com.wkodate.leetcode.LC0705_DesignHashSet;

public class MyHashSet2 {

    private boolean[] table;

    public MyHashSet2() {
        table = new boolean[1000001];
    }

    public void add(int key) {
        table[key] = true;
    }

    public void remove(int key) {
        table[key] = false;
    }

    public boolean contains(int key) {
        return table[key];
    }

    public static void main(String[] args) {
        MyHashSet2 hashSet = new MyHashSet2();
        hashSet.add(1);
        hashSet.add(2);
        // true
        System.out.println(hashSet.contains(1));
        // false
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        // true
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        // false
        System.out.println(hashSet.contains(2));
    }

}
