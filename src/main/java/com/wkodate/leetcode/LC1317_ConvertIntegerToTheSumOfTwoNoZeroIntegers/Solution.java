package com.wkodate.leetcode.LC1317_ConvertIntegerToTheSumOfTwoNoZeroIntegers;

import java.util.Arrays;

public class Solution {

    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for (int i = 1; i <= n; i++) {
            if (!String.valueOf(i).contains("0")
                    && !String.valueOf(n - i).contains("0")) {
                return new int[]{i, n - i};
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.getNoZeroIntegers(2)));
        System.out.println(Arrays.toString(s.getNoZeroIntegers(11)));
        System.out.println(Arrays.toString(s.getNoZeroIntegers(10000)));
        System.out.println(Arrays.toString(s.getNoZeroIntegers(69)));
        System.out.println(Arrays.toString(s.getNoZeroIntegers(1010)));
    }

}
