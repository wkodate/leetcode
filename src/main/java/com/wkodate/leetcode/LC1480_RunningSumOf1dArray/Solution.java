package com.wkodate.leetcode.LC1480_RunningSumOf1dArray;

import java.util.Arrays;

public class Solution {

    public int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,3,6,10]
        System.out.println(Arrays.toString(s.runningSum(new int[]{1, 2, 3, 4})));
        // [1,2,3,4,5]
        System.out.println(Arrays.toString(s.runningSum(new int[]{1, 1, 1, 1, 1})));
        // [3,4,6,16,17]
        System.out.println(Arrays.toString(s.runningSum(new int[]{3, 1, 2, 10, 1})));

    }

}
