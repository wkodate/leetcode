package com.wkodate.leetcode.LC0050_Powxn;

public class Solution {

    public double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        }
        if (x == -1) {
            if (n % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        }
        if (n == Integer.MIN_VALUE) {
            return 0;
        }
        double ans = 1;
        int absn = n;
        if (absn < 0) {
            absn *= -1;
        }
        for (int i = 0; i < absn; i++) {
            if (n >= 0) {
                ans *= x;
            } else {
                ans /= x;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // 0.00000
        System.out.println(s.myPow(2.00000, -2147483648));
        // 1
        System.out.println(s.myPow(1.00000, 2147483647));
        // 1024.00000
        System.out.println(s.myPow(2.00000, 10));
        // 9.26100
        System.out.println(s.myPow(2.10000, 3));
        // 0.25000
        System.out.println(s.myPow(2.00000, -2));
    }

}
