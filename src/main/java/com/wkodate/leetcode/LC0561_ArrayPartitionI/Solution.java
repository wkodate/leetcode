package com.wkodate.leetcode.LC0561_ArrayPartitionI;

import java.util.Arrays;

public class Solution {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            sum += nums[2 * i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrayPairSum(new int[]{1, 4, 3, 2}));
    }

}
