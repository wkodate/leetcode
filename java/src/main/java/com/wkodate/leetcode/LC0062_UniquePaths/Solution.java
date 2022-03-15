package com.wkodate.leetcode.LC0062_UniquePaths;

public class Solution {

    private static final int MOD = 2_147_483_647;
    private static long[] fac = new long[100000];
    private static long[] finv = new long[100000];
    private static long[] inv = new long[100000];

    public static void nCkInit() {
        fac[0] = fac[1] = 1;
        finv[0] = finv[1] = 1;
        inv[1] = 1;
        for (int i = 2; i < 100000; i++) {
            fac[i] = fac[i - 1] * i % MOD;
            inv[i] = MOD - inv[MOD % i] * (MOD / i) % MOD;
            finv[i] = finv[i - 1] * inv[i] % MOD;
        }
    }

    public static long nCk(int n, int k) {
        if (n < k) {
            return 0;
        }
        if (n < 0 || k < 0) {
            return 0;
        }
        return fac[n] * (finv[k] * finv[n - k] % MOD) % MOD;
    }

    public int uniquePaths(int m, int n) {
        nCkInit();
        return (int) nCk(m + n - 2, Math.min(m - 1, n - 1));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1916797311
        System.out.println(s.uniquePaths(51, 9));
        // 3
        System.out.println(s.uniquePaths(3, 2));
        // 28
        System.out.println(s.uniquePaths(7, 3));
    }

}
