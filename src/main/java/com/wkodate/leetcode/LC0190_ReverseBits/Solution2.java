package com.wkodate.leetcode.LC0190_ReverseBits;

public class Solution2 {

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= n & 1;
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        // 964176192
        //System.out.println(solution.reverseBits(43261596));
        System.out.println(solution.reverseBits(Integer.parseInt("00000010100101000001111010011100", 2)));
        // -1073741825
        //System.out.println(solution.reverseBits(-3));
        System.out.println(solution.reverseBits(Integer.parseInt("11111111111111111111111111111101", 2)));
    }

}
