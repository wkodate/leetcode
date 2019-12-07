package com.wkodate.leetcode.LC0136_SingleNumber;

import java.util.Arrays;

public class Solution {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
                continue;
            }
            return nums[i];
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{2, 2, 1}));
        System.out.println(solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(solution.singleNumber(new int[]{1}));
    }

}
