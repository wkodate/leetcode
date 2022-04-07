package com.wkodate.leetcode.LC0665_NonDecreasingArray;

public class Solution {

    public boolean checkPossibility(int[] nums) {
        boolean alreadyModified = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (alreadyModified) {
                    return false;
                }
                alreadyModified = true;
                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1];
                } else {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // True
        System.out.println(s.checkPossibility(new int[]{4, 2, 3}));
        // False
        System.out.println(s.checkPossibility(new int[]{4, 2, 1}));
        // False
        System.out.println(s.checkPossibility(new int[]{3, 4, 2, 3}));
        // True
        System.out.println(s.checkPossibility(new int[]{3, 4, 5, 3}));
        // False
        System.out.println(s.checkPossibility(new int[]{5, 2, 4, 5, 3}));
        // True
        System.out.println(s.checkPossibility(new int[]{-1, 4, 2, 3}));
    }

}
