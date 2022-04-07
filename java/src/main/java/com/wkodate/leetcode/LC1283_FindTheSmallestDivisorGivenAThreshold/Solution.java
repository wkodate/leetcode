package com.wkodate.leetcode.LC1283_FindTheSmallestDivisorGivenAThreshold;

import java.util.Arrays;

public class Solution {

    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] + 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += Math.ceil((double) nums[i] / mid);
            }
            if (sum <= threshold) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.smallestDivisor(new int[]{1,2,3}, 6));
        // 5
        System.out.println(s.smallestDivisor(new int[]{1, 2, 5, 9}, 6));
        // 3
        System.out.println(s.smallestDivisor(new int[]{2, 3, 5, 7, 11}, 11));
        // 4
        System.out.println(s.smallestDivisor(new int[]{19}, 5));
    }

}
