package com.wkodate.leetcode.LC0200_NumberOfIslands;

public class Solution2 {

    private int[] dx = new int[]{1, 0, -1, 0};
    private int[] dy = new int[]{0, 1, 0, -1};

    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length
                || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        for (int i = 0; i < dx.length; i++) {
            dfs(grid, x + dx[i], y + dy[i]);
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid.length == 0) {
            return count;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                dfs(grid, i, j);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 1
        char[][] grid1 = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(s.numIslands(grid1));
        // 3
        char[][] grid2 = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(s.numIslands(grid2));
        // 0
        char[][] grid3 = new char[][]{{}};
        System.out.println(s.numIslands(grid3));
    }

}
