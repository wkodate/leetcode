package com.wkodate.leetcode.LC0813_LargestSumOfAverages;

public class Solution {

    public double largestSumOfAverages(int[] A, int K) {
        double[] p = new double[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            p[i + 1] = p[i] + A[i];
        }

        double[] dp = new double[A.length];
        for (int i = 0; i < A.length; i++) {
            dp[i] = (p[A.length] - p[i]) / (A.length - i);
        }
        for (int k = 0; k < K - 1; k++) {
            for (int i = 0; i < A.length; i++) {
                for (int j = i + 1; j < A.length; j++) {
                    dp[i] = Math.max(dp[i], (p[j] - p[i]) / (j - i) + dp[j]);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3));
    }

}
