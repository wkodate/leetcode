package com.wkodate.leetcode.LC0283_MoveZeroes;

import java.util.Arrays;

public class Solution {

    public void moveZeroes(int[] nums) {
        int zeroPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (zeroPointer < i) {
                    nums[zeroPointer] = nums[i];
                    nums[i] = 0;
                }
                zeroPointer++;
            }
        }
        //System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.moveZeroes(new int[]{0, 1, 0, 3, 12});
        solution.moveZeroes(new int[]{1, 0, 1});
        solution.moveZeroes(new int[]{1});
    }

}
