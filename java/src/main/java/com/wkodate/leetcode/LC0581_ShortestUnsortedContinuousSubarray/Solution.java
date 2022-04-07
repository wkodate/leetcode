package com.wkodate.leetcode.LC0581_ShortestUnsortedContinuousSubarray;

public class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int minIdx = nums.length - 1;
        int maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    if (minIdx == nums.length - 1) {
                        minIdx = i - 1;
                    }
                    maxIdx = Math.max(maxIdx, j);
                }
            }
        }
        return Math.max(maxIdx - minIdx, 0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        // 2
        System.out.println(s.findUnsortedSubarray(new int[]{2, 1, 3, 4}));
        // 0
        System.out.println(s.findUnsortedSubarray(new int[]{1, 2, 3}));
        // 0
        System.out.println(s.findUnsortedSubarray(new int[]{1, 2, 2, 3}));
        // 0
        System.out.println(s.findUnsortedSubarray(new int[]{1, 1, 1}));
        // 0
        System.out.println(s.findUnsortedSubarray(new int[]{1, 1}));
        // 0
        System.out.println(s.findUnsortedSubarray(new int[]{1}));
    }

}
