package com.wkodate.leetcode.LC0905_SortArrayByParity;

import java.util.Arrays;

public class Solution {

    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 == 1 && A[j] % 2 == 0) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
            if (A[i] % 2 == 0) {
                i++;
            }
            if (A[j] % 2 == 1) {
                j--;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,4,3,1]
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{3, 1, 2, 4})));
        // [0,2,1]
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{0, 1, 2})));
        // [0,2,1]
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{0, 2, 1})));
    }

}
