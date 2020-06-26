package com.wkodate.leetcode.LC0287_FindTheDuplicateNumber;

import java.util.Arrays;

public class Solution {

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
        // 3
        System.out.println(s.findDuplicate(new int[] { 3, 1, 3, 4, 2 }));
        // 1
        System.out.println(s.findDuplicate(new int[] { 1, 1, 2 }));
    }

}
