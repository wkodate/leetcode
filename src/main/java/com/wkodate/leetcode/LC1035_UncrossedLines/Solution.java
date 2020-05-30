package com.wkodate.leetcode.LC1035_UncrossedLines;

public class Solution {

    private int lcs(int[] A, int[] B, int i, int j, int[][] dp) {
        if (i == A.length || j == B.length) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (A[i] == B[j]) {
            return dp[i][j] = 1 + lcs(A, B, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(lcs(A, B, i + 1, j, dp), lcs(A, B, i, j + 1, dp));
        }
    }

    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                dp[i][j] = -1;
            }
        }
        return lcs(A, B, 0, 0, dp);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.maxUncrossedLines(new int[] { 1, 4, 2 }, new int[] { 1, 2, 4 }));
        // 3
        System.out.println(s.maxUncrossedLines(new int[] { 2, 5, 1, 2, 5 }, new int[] { 10, 5, 2, 1, 5, 2 }));
        // 2
        System.out.println(s.maxUncrossedLines(new int[] { 1, 3, 7, 1, 7, 5 }, new int[] { 1, 9, 2, 5, 1 }));
    }
}
