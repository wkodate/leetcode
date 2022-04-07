package com.wkodate.leetcode.LC0169_MajorityElement;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (maxEntry == null || e.getValue() > maxEntry.getValue()) {
                maxEntry = e;
            }
        }
        return maxEntry.getKey();
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 3
        System.out.println(s.majorityElement(new int[]{3, 2, 3}));
        // 2
        System.out.println(s.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

}
