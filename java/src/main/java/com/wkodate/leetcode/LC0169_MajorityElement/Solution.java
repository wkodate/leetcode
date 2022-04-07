package com.wkodate.leetcode.LC0169_MajorityElement;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 3
        System.out.println(solution.majorityElement(new int[]{3, 2, 3}));
        // 2
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

}
