package com.wkodate.leetcode.LC1387_SortIntegersByThePowerValue;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Solution {

    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = lo; i <= hi; i++) {
            int cnt = 0;
            int p = i;
            while (p != 1) {
                cnt++;
                if (p % 2 == 0) {
                    p /= 2;
                } else {
                    p = 3 * p + 1;
                }
            }
            map.put(i, cnt);
        }
        Map<Integer, Integer> sorted = map.entrySet()
                                          .stream()
                                          .sorted(Entry.comparingByValue())
                                          .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                                                                    (e1, e2) -> e1, LinkedHashMap::new));
        int i = 0;
        for (Integer key : sorted.keySet()) {
            i++;
            if (i == k) {
                return key;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 148
        System.out.println(s.getKth(144, 163, 5));
        // 13
        System.out.println(s.getKth(12, 15, 2));
        // 1
        System.out.println(s.getKth(1, 1, 1));
        // 7
        System.out.println(s.getKth(7, 11, 4));
        // 13
        System.out.println(s.getKth(10, 20, 5));
        // 570
        System.out.println(s.getKth(1, 1000, 777));
    }

}
