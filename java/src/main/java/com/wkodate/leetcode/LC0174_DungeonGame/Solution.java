package com.wkodate.leetcode.LC0174_DungeonGame;

public class Solution {

    static int go(int[][] ar, int i, int j, int n, int m, int[][] dp) {
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int down = go(ar, i + 1, j, n, m, dp);
        int right = go(ar, i, j + 1, n, m, dp);
        if (right == Integer.MAX_VALUE && down == Integer.MAX_VALUE) {
            return ar[i][j] > 0 ? 1 : Math.abs(ar[i][j]) + 1;
        }
        int best = Math.min(down, right);
        if (ar[i][j] > 0) {
            dp[i][j] = Math.max(best - ar[i][j], 1);
        } else {
            dp[i][j] = Math.abs(ar[i][j]) + best;
        }
        return dp[i][j];
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        return go(dungeon, 0, 0, dungeon.length, dungeon[0].length, dp);
    }

    public static void main(String[] args) {
    }

}
