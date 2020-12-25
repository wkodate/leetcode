package com.wkodate.leetcode.LC1281_SubtractTheProductAndSumOfDigitsOfAnInteger;

public class Solution {

    public int subtractProductAndSum(int n) {
        int prod = 1;
        int sum = 0;
        while (n != 0) {
            int d = n % 10;
            n /= 10;
            prod *= d;
            sum += d;
        }
        return prod - sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 15
        System.out.println(s.subtractProductAndSum(234));
        // 21
        System.out.println(s.subtractProductAndSum(4421));
    }

}
