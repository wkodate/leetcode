package com.wkodate.leetcode.LC0896_MonotonicArray;

public class Solution2 {

    public boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                increasing = false;
            }
            if (A[i] < A[i + 1]) {
                decreasing = false;
            }
        }
        return increasing || decreasing;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // true
        System.out.println(s.isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(s.isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(s.isMonotonic(new int[]{1, 2, 4, 5}));
        System.out.println(s.isMonotonic(new int[]{1, 1, 1}));
        // false
        System.out.println(s.isMonotonic(new int[]{1, 3, 2}));
    }

}
