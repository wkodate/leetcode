package com.wkodate.leetcode.LC1344_AngleBetweenHandsOfAClock;

public class Solution {

    public double angleClock(int hour, int minutes) {
        double hdeg = ((double) hour * 360 / 12) % 360 + (double) minutes * 30 / 60;
        double mdeg = minutes * 360 / 60;
        double max = Math.max(hdeg, mdeg);
        double min = Math.min(hdeg, mdeg);
        return Math.min(max - min, 360 - (max - min));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 76.5
        System.out.println(s.angleClock(1, 57));
        // 165
        System.out.println(s.angleClock(12, 30));
        // 75
        System.out.println(s.angleClock(3, 30));
        // 7.5
        System.out.println(s.angleClock(3, 15));
        // 155
        System.out.println(s.angleClock(4, 50));
        // 0
        System.out.println(s.angleClock(12, 0));
    }

}
