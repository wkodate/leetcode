package com.wkodate.leetcode.LC0868_BinaryGap;

public class Solution {

    public int binaryGap(int N) {
        String binStr = Integer.toBinaryString(N);
        if (Integer.bitCount(N) <= 1) {
            return 0;
        }
        int max = 0;
        int pos = 0;
        boolean started = false;
        for (int i = 0; i < binStr.length(); i++) {
            char c = binStr.charAt(i);
            if (c == '1') {
                if (!started) {
                    started = true;
                } else {
                    max = Math.max(i - pos, max);
                    pos = i;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.binaryGap(22));
        // 2
        System.out.println(s.binaryGap(5));
        // 1
        System.out.println(s.binaryGap(6));
        // 0
        System.out.println(s.binaryGap(8));
    }

}
