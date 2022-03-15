package com.wkodate.leetcode.LC0371_SumOfTwoIntegers;

public class Solution {

    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        while (b != 0) {
            int c = a & b;
            a = a ^ b;
            b = c << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 3
        System.out.println(solution.getSum(1, 2));
        // 1
        System.out.println(solution.getSum(-2, 3));
        // -1
        System.out.println(solution.getSum(2147483647, -2147483648));
    }

}
