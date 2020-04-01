package com.wkodate.leetcode.LC0136_SingleNumber;

import java.util.Arrays;

public class Solution2 {

    public int singleNumber(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
            i += 2;
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 1
        System.out.println(s.singleNumber(new int[]{2, 2, 1}));
        // 4
        System.out.println(s.singleNumber(new int[]{4, 1, 2, 1, 2}));
        // 1
        System.out.println(s.singleNumber(new int[]{1}));
        // -2
        System.out.println(s.singleNumber(new int[]{-1, -1, -2}));
    }

}
