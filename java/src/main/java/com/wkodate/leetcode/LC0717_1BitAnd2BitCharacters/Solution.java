package com.wkodate.leetcode.LC0717_1BitAnd2BitCharacters;

public class Solution {

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i += 1;
            }
        }
        return i < bits.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isOneBitCharacter(new int[]{1, 0, 0}));
        // false
        System.out.println(s.isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }

}
