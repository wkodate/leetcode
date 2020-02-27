package com.wkodate.leetcode.LC0300_LongestIncreasingSubsequence;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4([2,3,7,101])
        System.out.println(s.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        // 0
        System.out.println(s.lengthOfLIS(new int[]{}));
        // 1
        System.out.println(s.lengthOfLIS(new int[]{0}));
        // 3
        System.out.println(s.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
        // 6
        System.out.println(s.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }

}
