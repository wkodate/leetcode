package com.wkodate.leetcode.LC0836_RectangleOverlap;

public class Solution {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[2] <= rec2[0] || rec1[3] <= rec2[1] || rec1[0] >= rec2[2] || rec1[1] >= rec2[3]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
        System.out.println(s.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
    }

}
