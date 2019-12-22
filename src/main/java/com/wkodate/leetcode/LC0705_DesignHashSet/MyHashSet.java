package com.wkodate.leetcode.LC0705_DesignHashSet;

public class MyHashSet {

    static final int NUM_BACKETS = 1000;
    boolean[][] hashTable;

    public MyHashSet() {
        hashTable = new boolean[NUM_BACKETS][];
    }

    private int hash(int key) {
        return key % NUM_BACKETS;
    }

    public void add(int key) {
        int hashKey = hash(key);
        if (hashTable[hashKey] == null) {
            hashTable[hashKey] = new boolean[NUM_BACKETS];
        }
        hashTable[hashKey][key / NUM_BACKETS] = true;
    }

    public void remove(int key) {
        int hashKey = hash(key);
        if (hashTable[hashKey] != null) {
            hashTable[hashKey][key / NUM_BACKETS] = false;
        }
    }

    public boolean contains(int key) {
        int hashKey = hash(key);
        return hashTable[hashKey] != null && hashTable[hashKey][key / NUM_BACKETS];
    }

    public static void main(String[] args) {
        MyHashSet mhs = new MyHashSet();
        mhs.add(1);
        mhs.add(2);
        // true
        System.out.println(mhs.contains(1));
        // false
        System.out.println(mhs.contains(3));
        mhs.add(2);
        // true
        System.out.println(mhs.contains(2));
        mhs.remove(2);
        // false
        System.out.println(mhs.contains(2));
    }

}
