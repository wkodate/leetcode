package com.wkodate.leetcode.LC0205_IsomorphicStrings;

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // true
        System.out.println(solution.isIsomorphic("egg", "add"));
        // false
        System.out.println(solution.isIsomorphic("foo", "bar"));
        // true
        System.out.println(solution.isIsomorphic("paper", "title"));
        // false
        System.out.println(solution.isIsomorphic("ab", "aa"));
        // true
        System.out.println(solution.isIsomorphic("qwertyuiop[]asdfghjkl;'\\zxcvbnm,./", "',.pyfgcrl/=aoeuidhtns-\\;qjkxbmwvz"));
    }

}
