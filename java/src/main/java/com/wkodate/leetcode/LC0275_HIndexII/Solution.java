package com.wkodate.leetcode.LC0275_HIndexII;

public class Solution {

    public int hIndex(int[] citations) {
        int left = -1;
        int right = citations.length;
        int mid;
        while (right - left > 1) {
            mid = left + (right - left) / 2;
            int h = citations.length - mid;
            if (citations[mid] >= h) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return citations.length - right;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.hIndex(new int[] { 0, 2, 5, 6, 7, 9, 10 }));
        // 3
        System.out.println(s.hIndex(new int[] { 0, 1, 3, 5, 6 }));
    }

}
