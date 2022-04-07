package com.wkodate.leetcode.LC0034_FindFirstAndLastPositionOfElementInSortedArray;

import java.util.Arrays;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
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
        if (nums.length <= 0 || right >= nums.length || nums[right] != target) {
            return new int[]{-1, -1};
        }
        int end = right;
        while (end <= nums.length - 1 && nums[end] == target) {
            end++;
        }
        return new int[]{right, end - 1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [3,4]
        System.out.println(Arrays.toString(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        // [-1,-1]
        System.out.println(Arrays.toString(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        // [-1, -1]
        System.out.println(Arrays.toString(s.searchRange(new int[]{}, 0)));
        // [0, 0]
        System.out.println(Arrays.toString(s.searchRange(new int[]{1}, 1)));
        // [-1, -1]
        System.out.println(Arrays.toString(s.searchRange(new int[]{2, 2}, 3)));

    }

}
