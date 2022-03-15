package com.wkodate.leetcode.LC0948_BagOfTokens;

import java.util.Arrays;

public class Solution {

    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int lo = 0;
        int hi = tokens.length - 1;
        int score = 0;
        int ans = 0;
        while (lo <= hi && (P >= tokens[lo] || score > 0)) {
            while (lo <= hi && P >= tokens[lo]) {
                P -= tokens[lo++];
                score++;
            }
            ans = Math.max(ans, score);
            if (lo <= hi && score > 0) {
                P += tokens[hi--];
                score--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
        // 0
        System.out.println(s.bagOfTokensScore(new int[]{100}, 50));
        // 1
        System.out.println(s.bagOfTokensScore(new int[]{100, 200}, 150));
    }

}
