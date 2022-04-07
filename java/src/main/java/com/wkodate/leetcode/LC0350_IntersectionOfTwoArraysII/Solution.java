package com.wkodate.leetcode.LC0350_IntersectionOfTwoArraysII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                ans.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
                if (map.get(nums2[i]) == 0) {
                    map.remove(nums2[i]);
                }
            }
        }
        int[] ansArray = new int[ans.size()];
        for (int i = 0; i < ansArray.length; i++) {
            ansArray[i] = ans.get(i);
        }
        return ansArray;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

}
