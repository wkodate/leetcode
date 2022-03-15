package com.wkodate.leetcode.LC0896_MonotonicArray;

public class Solution {

    private boolean isIncreased(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isDecreased(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isMonotonic(int[] A) {
        return isIncreased(A) || isDecreased(A);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(s.isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(s.isMonotonic(new int[]{1, 2, 4, 5}));
        System.out.println(s.isMonotonic(new int[]{1, 1, 1}));
        // false
        System.out.println(s.isMonotonic(new int[]{1, 3, 2}));
    }

}
