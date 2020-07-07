package com.wkodate.leetcode.LC0463_IslandPerimeter;

public class Solution {

    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        int[][] DXDY = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int cnt = 0;
                for (int k = 0; k < DXDY.length; k++) {
                    int x = i + DXDY[k][0];
                    int y = j + DXDY[k][1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
                        continue;
                    }
                    cnt++;
                }
                sum += 4 - cnt;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 16
        System.out.println(s.islandPerimeter(new int[][] {
                { 0, 1, 0, 0 },
                { 1, 1, 1, 0 },
                { 0, 1, 0, 0 },
                { 1, 1, 0, 0 }
        }));
    }

}
