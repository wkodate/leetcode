package com.wkodate.leetcode.LC1232_CheckIfItIsAStraightLine;

public class Solution {

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates[1][0] - coordinates[0][0] == 0) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] != coordinates[0][0]) {
                    return false;
                }
            }
            return true;
        }
        double a = (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        double b = coordinates[0][1] - a * coordinates[0][0];
        for (int i = 2; i < coordinates.length; i++) {
            if (coordinates[i][1] != a * (coordinates[i][0]) + b) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.checkStraightLine(
                new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } }));
        // false
        System.out.println(s.checkStraightLine(
                new int[][] { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 7 } }));
    }

}
