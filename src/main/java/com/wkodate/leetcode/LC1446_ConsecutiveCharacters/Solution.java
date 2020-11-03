package com.wkodate.leetcode.LC1446_ConsecutiveCharacters;

public class Solution {

    public int maxPower(String s) {
        int ans = 1;
        int cnt = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
            } else {
                cnt = 1;
            }
            ans = Math.max(cnt, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.maxPower("leetcode"));
        // 5
        System.out.println(s.maxPower("abbcccddddeeeeedcba"));
        // 5
        System.out.println(s.maxPower("triplepillooooow"));
        // 11
        System.out.println(s.maxPower("hooraaaaaaaaaaay"));
        // 1
        System.out.println(s.maxPower("tourist"));
    }

}
