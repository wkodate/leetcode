package com.wkodate.leetcode.LC0200_NumberOfIslands;

public class Solution3 {

    private static final int[][] DIR = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void dfs(int i, int j, char[][] grid) {
        grid[i][j] = '0';
        for (int k = 0; k < DIR.length; k++) {
            int x = i + DIR[k][0];
            int y = j + DIR[k][1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                dfs(x, y, grid);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(i, j, grid);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        // 1
        char[][] grid1 = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(s.numIslands(grid1));
        // 3
        char[][] grid2 = new char[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        System.out.println(s.numIslands(grid2));
        // 0
        char[][] grid3 = new char[][]{{}};
        System.out.println(s.numIslands(grid3));

    }
}
