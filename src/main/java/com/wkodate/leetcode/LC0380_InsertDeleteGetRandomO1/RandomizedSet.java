package com.wkodate.leetcode.LC0380_InsertDeleteGetRandomO1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random rand = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int loc = map.get(val);
        if (loc < list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(loc, last);
            map.put(last, loc);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        // true
        System.out.println(randomSet.insert(1));

        // Returns false as 2 does not exist in the set.
        // false
        System.out.println(randomSet.remove(2));

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        // true
        System.out.println(randomSet.insert(2));

        // getRandom should return either 1 or 2 randomly.
        // 1 or 2
        System.out.println(randomSet.getRandom());

        // Removes 1 from the set, returns true. Set now contains [2].
        // true
        System.out.println(randomSet.remove(1));

        // 2 was already in the set, so return false.
        // false
        System.out.println(randomSet.insert(2));

        // Since 2 is the only number in the set, getRandom always return 2.
        // 2
        System.out.println(randomSet.getRandom());
    }

}
