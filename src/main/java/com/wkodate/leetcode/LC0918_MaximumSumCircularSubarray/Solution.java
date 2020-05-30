package com.wkodate.leetcode.LC0918_MaximumSumCircularSubarray;

public class Solution {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubarraySumCircular(int[] A) {
        int maxSubArrayInMiddle = maxSubArray(A);
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            total += A[i];
            A[i] = -A[i];
        }
        int circular = total + maxSubArray(A);
        if (circular == 0) {
            return maxSubArrayInMiddle;
        }
        return Math.max(circular, maxSubArrayInMiddle);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // -1
        System.out.println(s.maxSubarraySumCircular(new int[] { -2, -3, -1 }));
        // 3
        System.out.println(s.maxSubarraySumCircular(new int[] { 1, -2, 3, -2 }));
        // 10
        System.out.println(s.maxSubarraySumCircular(new int[] { 5, -3, 5 }));
        // 4
        System.out.println(s.maxSubarraySumCircular(new int[] { 3, -1, 2, -1 }));
        // 3
        System.out.println(s.maxSubarraySumCircular(new int[] { 3, -2, 2, -3 }));
        // -1
        System.out.println(s.maxSubarraySumCircular(new int[] { -2, -3, -1 }));
        // -2
        System.out.println(s.maxSubarraySumCircular(new int[] { -2 }));
    }

}
