package com.wkodate.leetcode.LC0201_BitwiseANDOfNumbersRange;

public class Solution {

    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        String ms = Integer.toBinaryString(m);
        String ns = Integer.toBinaryString(n);
        if (ms.length() != ns.length()) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < ms.length(); i++) {
            char mc = ms.charAt(i);
            char nc = ns.charAt(i);
            if (mc != nc) {
                break;
            }
            if (mc == '0') {
                continue;
            }
            ans += Math.pow(2, ms.length() - i - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 10
        System.out.println(s.rangeBitwiseAnd(10, 11));
        // 5
        System.out.println(s.rangeBitwiseAnd(5, 5));
        // 4
        System.out.println(s.rangeBitwiseAnd(4, 7));
        // 4
        System.out.println(s.rangeBitwiseAnd(5, 7));
        // 6
        System.out.println(s.rangeBitwiseAnd(6, 7));
        // 7
        System.out.println(s.rangeBitwiseAnd(7, 7));
        // 0
        System.out.println(s.rangeBitwiseAnd(0, 1));
        System.out.println(s.rangeBitwiseAnd(0, 2147483647));
    }

}
