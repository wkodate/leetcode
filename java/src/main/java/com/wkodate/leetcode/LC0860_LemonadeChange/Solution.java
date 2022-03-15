package com.wkodate.leetcode.LC0860_LemonadeChange;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        map.put(20, 0);
        for (int bill : bills) {
            if (bill == 5) {
                map.put(5, map.get(5) + 1);
                continue;
            }
            if (bill == 10) {
                if (map.get(5) <= 0) {
                    return false;
                }
                map.put(5, map.get(5) - 1);
            } else if (bill == 20) {
                if (map.get(10) <= 0 && map.get(5) <= 2
                        || map.get(5) <= 0) {
                    return false;
                }
                if (map.get(10) >= 1) {
                    map.put(10, map.get(10) - 1);
                    map.put(5, map.get(5) - 1);
                } else {
                    map.put(5, map.get(5) - 3);
                }
            }
            map.put(bill, map.get(bill) + 1);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        // true
        System.out.println(s.lemonadeChange(new int[]{5, 5, 10}));
        // false
        System.out.println(s.lemonadeChange(new int[]{10, 10}));
        // false
        System.out.println(s.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
        // true
        System.out.println(s.lemonadeChange(new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5}));
    }

}
