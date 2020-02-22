package com.wkodate.leetcode.LC0162_FindPeakElement;

public class Solution {

    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((mid == 0 && nums[mid] > nums[mid + 1])
                    || (mid == nums.length - 1 && nums[mid - 1] < nums[mid])
                    || (mid > 0 && mid < nums.length - 1
                    && nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
            ) {
                return mid;
            }
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.findPeakElement(new int[]{1, 2, 3, 1}));
        // 1 or 5
        System.out.println(s.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        // 0
        System.out.println(s.findPeakElement(new int[]{1}));
        // 0
        System.out.println(s.findPeakElement(new int[]{2, 1}));
        // 1
        System.out.println(s.findPeakElement(new int[]{1, 2}));
        // -1
        System.out.println(s.findPeakElement(new int[]{}));
        // 1
        System.out.println(s.findPeakElement(new int[]{1, 2, 1}));
    }

}
