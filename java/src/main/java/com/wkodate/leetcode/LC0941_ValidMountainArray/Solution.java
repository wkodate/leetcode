package com.wkodate.leetcode.LC0941_ValidMountainArray;

public class Solution {

    public boolean validMountainArray(int[] A) {
        boolean increase = true;
        boolean decrease = false;
        if (A.length <= 2 || A[0] >= A[1]) {
            return false;
        }
        for (int i = 1; i < A.length - 1; i++) {
            if (increase) {
                if (A[i] == A[i + 1]) {
                    return false;
                }
                if (A[i] > A[i + 1]) {
                    increase = false;
                    decrease = true;
                }
                continue;
            }
            if (A[i] <= A[i + 1]) {
                return false;
            }
        }
        return !increase && decrease;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.validMountainArray(new int[]{2, 1}));
        // false
        System.out.println(s.validMountainArray(new int[]{3, 5, 5}));
        // true
        System.out.println(s.validMountainArray(new int[]{0, 3, 2, 1}));
        // false
        System.out.println(s.validMountainArray(new int[]{2, 2, 1}));
        // true
        System.out.println(s.validMountainArray(new int[]{1, 3, 2}));
    }

}
