package com.wkodate.leetcode.LC1266_MinimumTimeVisitingAllPoints;

public class Solution {

    public int minTimeToVisitAllPoints(int[][] points) {
        int t = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int[] start = points[i];
            int[] end = points[i + 1];
            t += Math.max(Math.abs(end[0] - start[0]), Math.abs(end[1] - start[1]));
        }
        return t;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.minTimeToVisitAllPoints(new int[][] { { 1, 1 }, { 3, 4 }, { -1, 0 } }));
        // 5
        System.out.println(s.minTimeToVisitAllPoints(new int[][] { { 3, 2 }, { -2, 2 } }));
    }

}
