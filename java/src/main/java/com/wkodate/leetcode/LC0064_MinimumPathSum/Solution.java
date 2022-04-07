package com.wkodate.leetcode.LC0064_MinimumPathSum;

public class Solution {

    public int minPathSum(int[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

}
