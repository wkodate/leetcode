package com.wkodate.leetcode.LC0922_SortArrayByParityII;

import java.util.Arrays;

public class Solution {

    public int[] sortArrayByParityII(int[] A) {
        int[] ans = new int[A.length];
        int evenIdx = 0;
        int oddIdx = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                ans[evenIdx] = A[i];
                evenIdx += 2;
            } else {
                ans[oddIdx] = A[i];
                oddIdx += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [4,5,2,7]
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{4, 2, 5, 7})));
        // []
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{})));
        // []
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{2})));
    }

}
