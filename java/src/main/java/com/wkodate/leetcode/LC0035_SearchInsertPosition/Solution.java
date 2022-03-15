package com.wkodate.leetcode.LC0035_SearchInsertPosition;

public class Solution {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 5));
        // 1
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 2));
        // 4
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 7));
        // 0
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

}
