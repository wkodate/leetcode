package com.wkodate.leetcode.LC1010_PairsOfSongsWithTotalDurationsDivisibleBy60;

public class Solution {

    public int numPairsDivisibleBy60(int[] time) {
        int[] rem = new int[60];
        for (int i = 0; i < time.length; i++) {
            rem[time[i] % 60]++;
        }
        int ans = Math.max(rem[0] * (rem[0] - 1) / 2, 0);
        ans += Math.max(rem[30] * (rem[30] - 1) / 2, 0);
        for (int i = 1; i < 30; i++) {
            ans += rem[i] * rem[60 - i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.numPairsDivisibleBy60(new int[] { 30, 20, 150, 100, 40 }));
        // 3
        System.out.println(s.numPairsDivisibleBy60(new int[] { 60, 60, 60 }));
    }

}
