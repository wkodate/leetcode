package com.wkodate.leetcode.LC1295_FindNumbersWithEvenNumberOfDigits;

public class Solution {

    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (String.valueOf(nums[i]).length() % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.findNumbers(new int[]{12, 345, 2, 6, 7896}));
        // 1
        System.out.println(s.findNumbers(new int[]{555, 901, 482, 1771}));
    }

}
