package com.wkodate.leetcode.LC0673_NumberOfLongestIncreasingSubsequence;

import java.util.Arrays;

public class Solution {

    public int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] lengths = new int[nums.length];
        int[] counts = new int[nums.length];
        Arrays.fill(counts, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) {
                    continue;
                }
                if (lengths[j] >= lengths[i]) {
                    lengths[i] = lengths[j] + 1;
                    counts[i] = counts[j];
                } else if (lengths[j] + 1 == lengths[i]) {
                    counts[i] += counts[j];
                }
            }
        }
        int longest = 0;
        for (int length : lengths) {
            longest = Math.max(longest, length);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.findNumberOfLIS(new int[] { 1, 3, 5, 4, 7 }));
        // 5
        System.out.println(s.findNumberOfLIS(new int[] { 2, 2, 2, 2, 2 }));
    }

}
