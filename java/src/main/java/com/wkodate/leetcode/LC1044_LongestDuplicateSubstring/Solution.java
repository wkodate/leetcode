package com.wkodate.leetcode.LC1044_LongestDuplicateSubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public String longestDupSubstring(String S) {
        int left = 1;
        int right = S.length();
        long mod = Long.MAX_VALUE / 26;
        String ans = "";
        int i;
        int flag;
        while (left <= right) {
            Set<Long> set = new HashSet<>();
            flag = 0;
            int mid = left + ((right - left) >> 1);
            long hash = 0;
            long p = 1;

            for (i = 0; i < mid; i++) {
                hash = (26 * hash + (S.charAt(i) - 'a')) % mod;
                p = (p * 26) % mod;
            }
            set.add(hash);
            for (i = 0; i + mid < S.length(); i++) {
                hash = (hash * 26 + (S.charAt(i + mid) - 'a') - ((S.charAt(i) - 'a') * p)) % mod;
                if (hash < 0) { hash += mod; }
                if (set.contains(hash)) {
                    flag = 1;
                    ans = S.substring(i + 1, i + mid + 1);
                    break;
                }
                set.add(hash);
            }
            if (flag == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ana
        System.out.println(s.longestDupSubstring("banana"));
        // ""
        System.out.println(s.longestDupSubstring("abcd"));

    }
}
