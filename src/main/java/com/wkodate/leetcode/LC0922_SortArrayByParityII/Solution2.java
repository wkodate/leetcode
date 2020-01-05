package com.wkodate.leetcode.LC0922_SortArrayByParityII;

import java.util.Arrays;

public class Solution2 {

    public int[] sortArrayByParityII(int[] A) {
        int oddIdx = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                while (A[oddIdx] % 2 == 1) {
                    oddIdx += 2;
                }
                int tmp = A[i];
                A[i] = A[oddIdx];
                A[oddIdx] = tmp;
            }
            i++;
        }
        return A;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // [4,5,2,7]
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{4, 2, 5, 7})));
        // []
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{})));
        // []
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{2})));
    }

}
