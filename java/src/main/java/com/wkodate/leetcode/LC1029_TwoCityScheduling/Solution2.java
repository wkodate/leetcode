package com.wkodate.leetcode.LC1029_TwoCityScheduling;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Solution2 {

    public int twoCitySchedCost(int[][] costs) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < costs.length; i++) {
            map.put(i, costs[i][0] - costs[i][1]);
        }
        Map<Integer, Integer> sorted = map.entrySet().stream()
                                          .sorted(Entry.comparingByValue())
                                          .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                                                                    (e1, e2) -> e1, LinkedHashMap::new));
        int i = 0;
        int ans = 0;
        for (Entry<Integer, Integer> e : sorted.entrySet()) {
            if (i < costs.length / 2) {
                ans += costs[e.getKey()][0];
            } else {
                ans += costs[e.getKey()][1];
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 1859
        System.out.println(
                s.twoCitySchedCost(new int[][] {
                        { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 }
                }));
        // 110
        System.out.println(
                s.twoCitySchedCost(new int[][] { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } }));
    }
}
