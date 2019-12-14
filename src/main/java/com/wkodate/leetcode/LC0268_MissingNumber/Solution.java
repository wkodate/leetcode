package com.wkodate.leetcode.LC0268_MissingNumber;

import java.util.Arrays;

public class Solution {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            if (i != nums[i]) {
                return i;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 2
        System.out.println(solution.missingNumber(new int[]{3, 0, 1}));
        // 8
        System.out.println(solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        // 1
        System.out.println(solution.missingNumber(new int[]{0}));
    }

}
