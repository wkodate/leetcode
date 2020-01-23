package com.wkodate.leetcode.LC0883_ProjectionAreaOf3DShapes;

public class Solution {

    public int projectionArea(int[][] grid) {
        int xy = 0;
        int yz = 0;
        int zx = 0;
        for (int i = 0; i < grid.length; i++) {
            int yzMax = 0;
            int zxMax = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    xy++;
                }
                yzMax = Math.max(yzMax, grid[i][j]);
                zxMax = Math.max(zxMax, grid[j][i]);
            }
            yz += yzMax;
            zx += zxMax;
        }
        return xy + yz + zx;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.projectionArea(new int[][]{{2}}));
        // 17
        System.out.println(s.projectionArea(new int[][]{{1, 2}, {3, 4}}));
        // 8
        System.out.println(s.projectionArea(new int[][]{{1, 0}, {0, 2}}));
        // 14
        System.out.println(s.projectionArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        // 21
        System.out.println(s.projectionArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
    }

}
