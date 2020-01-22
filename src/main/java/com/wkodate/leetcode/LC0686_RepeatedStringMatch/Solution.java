package com.wkodate.leetcode.LC0686_RepeatedStringMatch;

public class Solution {

    public int repeatedStringMatch(String A, String B) {
        int q = 1;
        StringBuilder sb = new StringBuilder(A);
        while (sb.length() < B.length()) {
            sb.append(A);
            q++;
        }
        if (sb.indexOf(B) >= 0) {
            return q;
        }
        if (sb.append(A).indexOf(B) >= 0) {
            return q + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.repeatedStringMatch("abcd", "cdabcdab"));
        // 2
        System.out.println(s.repeatedStringMatch("a", "aa"));
        // 1
        System.out.println(s.repeatedStringMatch("aa", "a"));
        // 1
        System.out.println(s.repeatedStringMatch("abab", "aba"));
        // 4
        System.out.println(s.repeatedStringMatch("abc", "cabcabca"));
        // 2
        System.out.println(s.repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ba"));
    }

}
