package com.wkodate.leetcode.LC0292_NimGame;

public class Solution {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.canWinNim(4));
        // true
        System.out.println(s.canWinNim(2));
    }

}
