package com.wkodate.leetcode.LC0821_ShortestDistanceToACharacter;

import java.util.Arrays;

public class Solution {

    public int[] shortestToChar(String S, char C) {
        boolean[] isC = new boolean[S.length()];
        int[] ans = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                isC[i] = true;
            }
        }
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (i + j <= S.length() - 1 && isC[i + j]
                        || i - j >= 0 && isC[i - j]) {
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [3,2,1,0,1,0,0,1,2,2,1,0]
        System.out.println(Arrays.toString(s.shortestToChar("loveleetcode", 'e')));
        // [3,2,1,0]
        System.out.println(Arrays.toString(s.shortestToChar("aaab", 'b')));
    }

}
