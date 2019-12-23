package com.wkodate.leetcode.LC0509_FibonacciNumber;

public class Solution {

    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return fib(N - 1) + fib(N - 2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.fib(2));
        // 2
        System.out.println(s.fib(3));
        // 3
        System.out.println(s.fib(4));
    }

}
