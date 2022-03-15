package com.wkodate.leetcode.LC0215_KthLargestElementInAnArray;

import java.util.Arrays;

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
        // 4
        System.out.println(s.findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
    }

}
