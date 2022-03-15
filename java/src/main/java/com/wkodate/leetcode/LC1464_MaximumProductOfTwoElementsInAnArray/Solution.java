package com.wkodate.leetcode.LC1464_MaximumProductOfTwoElementsInAnArray;

public class Solution {

    public int maxProduct(int[] nums) {
        int ans = (nums[0] - 1) * (nums[1] - 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans = Math.max((nums[i] - 1) * (nums[j] - 1), ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 36
        System.out.println(s.maxProduct(new int[]{10, 2, 5, 2}));
        // 12
        System.out.println(s.maxProduct(new int[]{3, 4, 5, 2}));
        // 16
        System.out.println(s.maxProduct(new int[]{1, 5, 4, 5}));
        // 12
        System.out.println(s.maxProduct(new int[]{3, 7}));
    }

}
