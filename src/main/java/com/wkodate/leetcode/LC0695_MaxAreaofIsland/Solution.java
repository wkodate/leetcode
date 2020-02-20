package com.wkodate.leetcode.LC0695_MaxAreaofIsland;

public class Solution {

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
                || grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        return 1 + dfs(grid, x + 1, y) + dfs(grid, x - 1, y)
                + dfs(grid, x, y + 1) + dfs(grid, x, y - 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] r = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        // 6
        System.out.println(s.maxAreaOfIsland(r));
        int[][] r2 = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        // 0
        System.out.println(s.maxAreaOfIsland(r2));

        int[][] r3 = new int[][]{
                {0, 1, 1},
                {1, 1, 0}
        };
        // 4
        System.out.println(s.maxAreaOfIsland(r3));
    }

}
