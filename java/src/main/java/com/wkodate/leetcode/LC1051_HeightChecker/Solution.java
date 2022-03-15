package com.wkodate.leetcode.LC1051_HeightChecker;

import java.util.Arrays;

public class Solution {

    public int heightChecker(int[] heights) {
        int[] org = new int[heights.length];
        System.arraycopy(heights, 0, org, 0, heights.length);
        Arrays.sort(heights);

        int count = 0;
        for (int i = 0; i < org.length; i++) {
            if (org[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
        // 0
        System.out.println(s.heightChecker(new int[]{1, 1, 1, 1, 1, 1}));
    }

}
