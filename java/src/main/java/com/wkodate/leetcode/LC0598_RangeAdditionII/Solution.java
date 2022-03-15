package com.wkodate.leetcode.LC0598_RangeAdditionII;

public class Solution {

    public int maxCount(int m, int n, int[][] ops) {
        int rangex = m;
        int rangey = n;
        for (int[] op : ops) {
            if (op.length == 0
                    || op[0] == 0 && op[1] == 0) {
                continue;
            }
            if (op[0] < rangex) {
                rangex = op[0];
            }
            if (op[1] < rangey) {
                rangey = op[1];
            }
        }
        return rangex * rangey;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.maxCount(3, 3, new int[][]{{2, 2}, {3, 3}}));
        // 1600000000
        System.out.println(s.maxCount(40000, 40000, new int[][]{{}}));
        // 9
        System.out.println(s.maxCount(3, 3, new int[][]{{}}));
    }

}
