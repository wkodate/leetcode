package com.wkodate.leetcode.LC0949_LargestTimeForGivenDigits;

public class Solution {

    public String largestTimeFromDigits(int[] A) {
        int hour = -1;
        int min = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    int l = 6 - i - j - k;
                    int h = 10 * A[i] + A[j];
                    int m = 10 * A[k] + A[l];
                    if (h <= 23 && m <= 59
                            && (h > hour || (h == hour && m > min))) {
                        hour = h;
                        min = m;
                    }
                }
            }
        }
        if (hour < 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", hour));
        sb.append(":");
        sb.append(String.format("%02d", min));
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 23:41
        System.out.println(s.largestTimeFromDigits(new int[]{1, 2, 3, 4}));
        // ""
        System.out.println(s.largestTimeFromDigits(new int[]{5, 5, 5, 5}));
        // "11:10"
        System.out.println(s.largestTimeFromDigits(new int[]{1, 1, 0, 1}));
    }

}
