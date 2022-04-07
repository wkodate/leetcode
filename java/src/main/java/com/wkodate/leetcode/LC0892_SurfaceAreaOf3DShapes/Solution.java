package com.wkodate.leetcode.LC0892_SurfaceAreaOf3DShapes;

public class Solution {

    public int surfaceArea(int[][] grid) {
        int[] diffRow = new int[]{0, 1, 0, -1};
        int[] diffCol = new int[]{1, 0, -1, 0};
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] <= 0) {
                    continue;
                }
                ans += 2;
                for (int k = 0; k < diffRow.length; k++) {
                    int nrow = i + diffRow[k];
                    int ncol = j + diffCol[k];
                    int neighbor = 0;
                    if (0 <= nrow && nrow < grid.length && 0 <= ncol && ncol < grid[0].length) {
                        neighbor = grid[nrow][ncol];
                    }
                    ans += Math.max(grid[i][j] - neighbor, 0);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 10
        System.out.println(s.surfaceArea(new int[][]{{2}}));
        // 34
        System.out.println(s.surfaceArea(new int[][]{{1, 2}, {3, 4}}));
        // 16
        System.out.println(s.surfaceArea(new int[][]{{1, 0}, {0, 2}}));
        // 32
        System.out.println(s.surfaceArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        // 46
        System.out.println(s.surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
    }

}
