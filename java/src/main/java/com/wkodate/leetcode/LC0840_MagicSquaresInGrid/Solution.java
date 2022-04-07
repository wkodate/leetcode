package com.wkodate.leetcode.LC0840_MagicSquaresInGrid;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private boolean hasDuplicate(int x, int y, int[][] grid) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[x + i][y + j];
                if (num < 1 || num > 9 || set.contains(num)) {
                    return true;
                }
                set.add(grid[x + i][y + j]);
            }
        }
        return false;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (grid[i + 1][j + 1] != 5) {
                    continue;
                }
                if (hasDuplicate(i, j, grid)) {
                    continue;
                }
                if (grid[i][j] + grid[i][j + 1] + grid[i][j + 2] == 15
                        && grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] == 15
                        && grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] == 15
                        && grid[i][j] + grid[i + 1][j] + grid[i + 2][j] == 15
                        && grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] == 15
                        && grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] == 15
                        && grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] == 15
                        && grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2] == 15
                ) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.numMagicSquaresInside(new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}}));
        // 0
        System.out.println(s.numMagicSquaresInside(new int[][]{{5, 5, 5}, {5, 5, 5}, {5, 5, 5}}));
        // 0
        System.out.println(s.numMagicSquaresInside(new int[][]{{1, 8, 6}, {10, 5, 0}, {4, 2, 9}}));
        // 1
        System.out.println(s.numMagicSquaresInside(new int[][]{{3, 2, 9, 2, 7}, {6, 1, 8, 4, 2}, {7, 5, 3, 2, 7}, {2, 9, 4, 9, 6}, {4, 3, 8, 2, 5}}));
    }

}
