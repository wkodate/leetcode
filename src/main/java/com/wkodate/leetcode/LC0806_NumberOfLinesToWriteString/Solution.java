package com.wkodate.leetcode.LC0806_NumberOfLinesToWriteString;

import java.util.Arrays;

public class Solution {

    public int[] numberOfLines(int[] widths, String S) {
        int lines = 1;
        int units = 0;
        for (int i = 0; i < S.length(); i++) {
            int c = S.charAt(i) - 'a';
            if (units + widths[c] > 100) {
                lines++;
                units = 0;
            }
            units += widths[c];
        }
        return new int[]{lines, units};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [3,60]
        int[] widths1 = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String S1 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Arrays.toString(s.numberOfLines(widths1, S1)));
        // [2,4]
        int[] widths2 = new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String S2 = "bbbcccdddaaa";
        System.out.println(Arrays.toString(s.numberOfLines(widths2, S2)));
    }

}
