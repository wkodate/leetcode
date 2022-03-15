package com.wkodate.leetcode.LC0153_FindMinimumInRotatedSortedArray;

public class Solution {

    public int findMin(int[] nums) {
        if (nums.length <= 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((mid == 0 && nums[mid] < nums[mid + 1])
                    || (mid == nums.length - 1 && nums[mid - 1] < nums[mid])
                    || (mid > 0 && mid < nums.length - 1
                    && nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1])
            ) {
                return nums[mid];
            }
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.findMin(new int[]{3, 4, 5, 1, 2}));
        // 0
        System.out.println(s.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        // 1
        System.out.println(s.findMin(new int[]{1, 3}));
        // 1
        System.out.println(s.findMin(new int[]{1}));
        // 1
        System.out.println(s.findMin(new int[]{5, 1, 3}));
        // 1
        System.out.println(s.findMin(new int[]{3, 1}));
        // 1
        System.out.println(s.findMin(new int[]{2, 3, 1}));
    }

}
