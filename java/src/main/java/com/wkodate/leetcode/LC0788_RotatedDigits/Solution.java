package com.wkodate.leetcode.LC0788_RotatedDigits;

public class Solution {

    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            boolean good = false;
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '3' || c == '4' || c == '7') {
                    good = false;
                    break;
                }
                if (c == '2' || c == '5' || c == '6' || c == '9') {
                    good = true;
                }
            }
            if (good) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.rotatedDigits(10));
    }

}
