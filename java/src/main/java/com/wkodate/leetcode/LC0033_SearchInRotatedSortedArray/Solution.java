package com.wkodate.leetcode.LC0033_SearchInRotatedSortedArray;

public class Solution {

    public int search(int[] nums, int target) {
        if (nums.length <= 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (target > nums[nums.length - 1]) {
            left = 0;
        }
        if (target <= nums[nums.length - 1]) {
            right = nums.length - 1;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right >= 0 && right <= nums.length - 1 && nums[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        // -1
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        // -1
        System.out.println(s.search(new int[]{}, 5));
        // 0
        System.out.println(s.search(new int[]{1, 3}, 1));
        // 1
        System.out.println(s.search(new int[]{1, 3}, 3));
        // -1
        System.out.println(s.search(new int[]{1}, 2));
        // 1
        System.out.println(s.search(new int[]{5, 1, 3}, 1));
        // 1
        System.out.println(s.search(new int[]{3, 1}, 1));
    }

}
