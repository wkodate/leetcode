package com.wkodate.leetcode.LC1523_CountOddNumbersInAnIntervalRange;

public class Solution {

    public int countOdds(int low, int high) {
        if (high % 2 != 0) {
            high++;
        }
        if (low % 2 != 0) {
            low--;
        }
        return (high - low) / 2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.countOdds(3, 6));
        // 3
        System.out.println(s.countOdds(3, 7));
        // 3
        System.out.println(s.countOdds(3, 8));
        // 4
        System.out.println(s.countOdds(3, 9));
        // 1
        System.out.println(s.countOdds(8, 10));

    }

}
