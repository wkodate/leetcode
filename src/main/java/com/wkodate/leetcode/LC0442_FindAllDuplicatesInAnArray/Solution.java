package com.wkodate.leetcode.LC0442_FindAllDuplicatesInAnArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 2) {
                list.add(e.getKey());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,3]
        System.out.println(s.findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
    }

}
