package com.wkodate.leetcode.LC0567_PermutationInString;

public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i) - 'a']++;
        }
        int start = 0;
        int end = 0;
        while (end < s2.length()) {
            // valid anagram
            if (map[s2.charAt(end) - 'a'] > 0) {
                map[s2.charAt(end++) - 'a']--;
                // window size equal to size of P
                if (end - start == s1.length()) {
                    return true;
                }
            } else if (start == end) {
                // window is of size 0
                start++;
                end++;
            } else {
                // decrease window size
                map[s2.charAt(start++) - 'a']++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.checkInclusion("dinitrophenylhydrazine", "acetylphenylhydrazine"));
        // True
        System.out.println(s.checkInclusion("ab", "eidbaooo"));
        // False
        System.out.println(s.checkInclusion("ab", "eidboaoo"));
    }

}
