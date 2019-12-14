package com.wkodate.leetcode.LC0190_ReverseBits;

public class Solution {

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += n & 1;
            n >>>= 1;
            if (i < 31) {
                ans <<= 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 964176192
        System.out.println(solution.reverseBits(43261596));
    }

}
