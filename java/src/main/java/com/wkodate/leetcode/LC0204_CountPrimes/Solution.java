package com.wkodate.leetcode.LC0204_CountPrimes;

public class Solution {

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = 2; i * j <= n; j++) {
                isPrime[i * j] = false;
            }
        }
        int primeCount = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                primeCount++;
            }
        }
        return primeCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 4
        System.out.println(solution.countPrimes(10));
        // 0
        System.out.println(solution.countPrimes(2));
        // avoid time limit exceeded
        System.out.println(solution.countPrimes(499979));
    }

}
