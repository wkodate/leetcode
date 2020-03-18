package com.wkodate.leetcode.LC0338_CountingBits;

import java.util.Arrays;

public class Solution {

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,1,1]
        System.out.println(Arrays.toString(s.countBits(2)));
        // [0,1,1,2,1,2]
        System.out.println(Arrays.toString(s.countBits(5)));
    }

}
