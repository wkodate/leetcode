package com.wkodate.leetcode.LC0724_FindPivotIndex;

public class Solution {

    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < sum.length; i++) {
            right = sum[sum.length - 1] - sum[i];
            if (left == right) {
                return i;
            }
            left = sum[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[]{-1, -1, -1, 0, 1, 1};
        System.out.println(solution.pivotIndex(input));
    }

}
