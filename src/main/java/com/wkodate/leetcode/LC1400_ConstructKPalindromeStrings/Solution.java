package com.wkodate.leetcode.LC1400_ConstructKPalindromeStrings;

public class Solution {

    public boolean canConstruct(String s, int k) {
        int even = 0;
        int[] ch = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (ch[s.charAt(i) - 'a'] == 1) {
                even++;
                ch[s.charAt(i) - 'a'] = 0;
            } else {
                ch[s.charAt(i) - 'a']++;
            }
        }
        int odd = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 1) {
                odd++;
            }
        }
        if (odd > k) {
            return false;
        }
        return odd + 2 * even >= k;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.canConstruct("qlkzenwmmnpkopu", 15));
        // true
        System.out.println(s.canConstruct("true", 4));
        // true
        System.out.println(s.canConstruct("annabelle", 2));
        // false
        System.out.println(s.canConstruct("leetcode", 3));
        // true
        System.out.println(s.canConstruct("yzyzyzyzyzyzyzy", 2));
        // false
        System.out.println(s.canConstruct("cr", 7));
    }

}
