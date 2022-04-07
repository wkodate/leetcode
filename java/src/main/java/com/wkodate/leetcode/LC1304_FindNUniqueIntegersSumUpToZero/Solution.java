package com.wkodate.leetcode.LC1304_FindNUniqueIntegersSumUpToZero;

import java.util.Arrays;

public class Solution {

    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int num = 1;
        for (int i = 0; i < n - 2; i += 2) {
            ans[i] = num;
            ans[i + 1] = -1 * num;
            num++;
        }
        if (n % 2 == 0) {
            ans[n - 2] = num;
            ans[n - 1] = -1 * num;
        } else {
            ans[n - 1] = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [-7,-1,1,3,4]
        System.out.println(Arrays.toString(s.sumZero(5)));
        // [-1,0,1]
        System.out.println(Arrays.toString(s.sumZero(3)));
        // [0]
        System.out.println(Arrays.toString(s.sumZero(1)));
    }

}
