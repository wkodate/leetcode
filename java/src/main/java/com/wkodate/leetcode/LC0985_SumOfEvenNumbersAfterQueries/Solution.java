package com.wkodate.leetcode.LC0985_SumOfEvenNumbersAfterQueries;

import java.util.Arrays;

public class Solution {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[A.length];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                sum += A[i];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            if (A[index] % 2 == 0) {
                sum -= A[index];
            }
            A[index] += val;
            if (A[index] % 2 == 0) {
                sum += A[index];
            }
            ans[i] = sum;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = new int[]{1, 2, 3, 4};
        int[][] queries = new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        System.out.println(Arrays.toString(s.sumEvenAfterQueries(A, queries)));
        System.out.println(Arrays.toString(s.sumEvenAfterQueries(new int[]{}, new int[][]{})));
    }

}
