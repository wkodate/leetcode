package com.wkodate.leetcode.LC1254_NumberOfClosedIslands;

public class Solution {

    private void fill(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length
                || grid[x][y] == 1) {
            return;
        }
        grid[x][y] = 1;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        for (int i = 0; i < dx.length; i++) {
            fill(grid, x + dx[i], y + dy[i]);
        }
    }

    public int closedIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                    fill(grid, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    fill(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        // 2
        System.out.println(s.closedIsland(grid));
        int[][] grid2 = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}
        };
        // 1
        System.out.println(s.closedIsland(grid2));
    }

}
