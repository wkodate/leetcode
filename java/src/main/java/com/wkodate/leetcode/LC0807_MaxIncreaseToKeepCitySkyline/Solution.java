package com.wkodate.leetcode.LC0807_MaxIncreaseToKeepCitySkyline;

public class Solution {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] topBottom = new int[grid.length];
        int[] leftRight = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                topBottom[j] = Math.max(topBottom[j], grid[i][j]);
                leftRight[i] = Math.max(leftRight[i], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans += Math.min(topBottom[i], leftRight[j]) - grid[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}));
    }

}
