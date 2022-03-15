package com.wkodate.leetcode.LC0035_SearchInsertPosition;

public class Solution2 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
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
