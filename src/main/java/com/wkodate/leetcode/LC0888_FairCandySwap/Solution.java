package com.wkodate.leetcode.LC0888_FairCandySwap;

import java.util.Arrays;

public class Solution {

    public int[] fairCandySwap(int[] A, int[] B) {
        int[] ans = new int[2];
        int asum = 0;
        int bsum = 0;
        for (int i = 0; i < A.length; i++) {
            asum += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            bsum += B[i];
        }
        int exchangedSum = (asum + bsum) / 2;
        boolean exchanged = false;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (asum - exchangedSum == A[i] - B[j]) {
                    ans[0] = A[i];
                    ans[1] = B[j];
                    exchanged = true;
                    break;
                }
            }
            if (exchanged) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2]
        System.out.println(Arrays.toString(s.fairCandySwap(new int[]{1, 1}, new int[]{2, 2})));
        // [1,2]
        System.out.println(Arrays.toString(s.fairCandySwap(new int[]{1, 2}, new int[]{2, 3})));
        // [2,2]
        System.out.println(Arrays.toString(s.fairCandySwap(new int[]{2}, new int[]{1, 3})));
        // [5,4]
        System.out.println(Arrays.toString(s.fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})));
    }

}
