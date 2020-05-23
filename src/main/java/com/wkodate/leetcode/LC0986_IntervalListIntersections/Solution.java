package com.wkodate.leetcode.LC0986_IntervalListIntersections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<>();
        int ai = 0;
        int bi = 0;
        while (ai < A.length && bi < B.length) {
            int start = Math.max(A[ai][0], B[bi][0]);
            int end = Math.min(A[ai][1], B[bi][1]);
            if (start <= end) {
                ans.add(new int[] { start, end });
            }
            if (A[ai][1] < B[bi][1]) {
                ai++;
            } else {
                bi++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        int[][] A = new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        int[][] B = new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
        System.out.println(Arrays.deepToString(s.intervalIntersection(A, B)));
    }

}
