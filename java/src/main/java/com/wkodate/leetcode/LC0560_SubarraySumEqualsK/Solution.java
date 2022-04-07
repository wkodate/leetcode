package com.wkodate.leetcode.LC0560_SubarraySumEqualsK;

public class Solution {

    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sum[0] = nums[0];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
            if (sum[i] == k) {
                cnt++;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (sum[j] - sum[i - 1] == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.subarraySum(new int[]{1, 1, 1}, 2));
        // 1
        System.out.println(s.subarraySum(new int[]{-1, -1, 1}, 0));
        // 1
        System.out.println(s.subarraySum(new int[]{1}, 1));
    }

}
