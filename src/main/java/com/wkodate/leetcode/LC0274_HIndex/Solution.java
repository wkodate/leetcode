package com.wkodate.leetcode.LC0274_HIndex;

import java.util.Arrays;

public class Solution {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                return citations.length - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hIndex(new int[] { 3, 0, 6, 1, 5 }));
    }

}
