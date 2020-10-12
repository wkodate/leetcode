package com.wkodate.leetcode.LC1009_ComplementOfBase10Integer;

public class Solution {

    public int bitwiseComplement(int N) {
        String bitStr = Integer.toBinaryString(N);
        int ans = 0;
        for (int i = 0; i < bitStr.length(); i++) {
            char c = bitStr.charAt(bitStr.length() - i - 1);
            if (c == '0') {
                ans += Math.pow(2, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.bitwiseComplement(5));
        // 0
        System.out.println(s.bitwiseComplement(7));
        // 5
        System.out.println(s.bitwiseComplement(10));
    }

}
