package com.wkodate.leetcode.ThirtyDayLeetCodingChallenge.PerformStringShifts;

public class Solution {

    public String stringShift(String s, int[][] shift) {
        int j = 0;
        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0) {
                j += shift[i][1];
                continue;
            }
            j -= shift[i][1];
        }
        int idx = (j % s.length() + s.length()) % s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s, idx, s.length());
        sb.append(s, 0, idx);
        return sb.toString();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // cab
        System.out.println(s.stringShift("abc", new int[][]{{0, 1}, {1, 2}}));
        // efgabcd
        System.out.println(s.stringShift("abcdefg", new int[][]{{1, 1}, {1, 1}, {0, 2}, {1, 3}}));
    }
}
