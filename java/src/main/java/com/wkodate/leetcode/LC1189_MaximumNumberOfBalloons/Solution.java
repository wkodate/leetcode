package com.wkodate.leetcode.LC1189_MaximumNumberOfBalloons;

public class Solution {

    public int maxNumberOfBalloons(String text) {
        int[] charCnt = new int[26];
        for (int i = 0; i < text.length(); i++) {
            charCnt[text.charAt(i) - 'a']++;
        }
        int ans = charCnt[0];
        ans = Math.min(charCnt['b' - 'a'], ans);
        ans = Math.min(charCnt['n' - 'a'], ans);
        ans = Math.min(charCnt['l' - 'a'] / 2, ans);
        return Math.min(charCnt['o' - 'a'] / 2, ans);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.maxNumberOfBalloons("nlaebolko"));
        // 2
        System.out.println(s.maxNumberOfBalloons("loonbalxballpoon"));
        // 0
        System.out.println(s.maxNumberOfBalloons("leetcode"));
    }

}
