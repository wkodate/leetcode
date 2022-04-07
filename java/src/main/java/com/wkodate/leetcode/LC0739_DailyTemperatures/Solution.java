package com.wkodate.leetcode.LC0739_DailyTemperatures;

import java.util.Arrays;

public class Solution {

    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int count = 0;
            for (int j = i + 1; j < T.length; j++) {
                count++;
                if (T[i] < T[j]) {
                    ans[i] = count;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

}
