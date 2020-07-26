package com.wkodate.leetcode.LC0154_FindMinimumInRotatedSortedArrayII;

public class Solution {

    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.findMin(new int[] { 1, 3, 5 }));
        // 0
        System.out.println(s.findMin(new int[] { 2, 2, 2, 0, 1 }));
    }

}
