package com.wkodate.leetcode.LC0643_MaximumAverageSubarrayI;

public class Solution {

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = 1; i <= nums.length - k; i++) {
            sum += nums[i + k - 1] - nums[i - 1];
            max = Math.max(max, sum);
        }
        return (double) max / k;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 12.75
        System.out.println(s.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

}
