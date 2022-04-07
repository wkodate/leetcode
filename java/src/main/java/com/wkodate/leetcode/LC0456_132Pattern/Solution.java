package com.wkodate.leetcode.LC0456_132Pattern;

public class Solution {

    public boolean find132pattern(int[] nums) {
        int mini = nums[0];
        for (int j = 1; j < nums.length - 1; j++) {
            mini = Math.min(mini, nums[j]);
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] < nums[j] && mini < nums[k])
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.find132pattern(new int[]{1, 2, 3, 4, -4, -3, -5, -1}));
        // true
        System.out.println(s.find132pattern(new int[]{3, 5, 0, 3, 4}));
        // false
        System.out.println(s.find132pattern(new int[]{1, 2, 3, 4}));
        // true
        System.out.println(s.find132pattern(new int[]{3, 1, 4, 2}));
        // true
        System.out.println(s.find132pattern(new int[]{-1, 3, 2, 0}));
    }

}

