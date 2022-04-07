package com.wkodate.leetcode.LC0035_SearchInsertPosition;

public class Solution3 {

    public int searchInsert(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        int mid;
        while (right - left > 1) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 2
        System.out.println(s.searchInsert(new int[] { 1, 3, 5, 6 }, 5));
        // 1
        System.out.println(s.searchInsert(new int[] { 1, 3, 5, 6 }, 2));
        // 4
        System.out.println(s.searchInsert(new int[] { 1, 3, 5, 6 }, 7));
        // 0
        System.out.println(s.searchInsert(new int[] { 1, 3, 5, 6 }, 0));
    }

}
