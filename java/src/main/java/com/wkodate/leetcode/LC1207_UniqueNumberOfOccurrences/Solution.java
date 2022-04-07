package com.wkodate.leetcode.LC1207_UniqueNumberOfOccurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> occur = new HashSet<>();
        for (Integer value : map.values()) {
            if (occur.contains(value)) {
                return false;
            }
            occur.add(value);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(s.uniqueOccurrences(new int[]{1, 2}));
        System.out.println(s.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }

}
