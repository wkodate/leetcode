package com.wkodate.leetcode.LC1365_HowManyNumbersAreSmallerThanTheCurrentNumber;

import java.util.Arrays;

public class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    cnt++;
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [4,0,1,1,3]
        System.out.println(Arrays.toString(s.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
        // [2,1,0,3]
        System.out.println(Arrays.toString(s.smallerNumbersThanCurrent(new int[]{6, 5, 4, 8})));
        // [0,0,0,0]
        System.out.println(Arrays.toString(s.smallerNumbersThanCurrent(new int[]{7, 7, 7, 7})));
    }

}
