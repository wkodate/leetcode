package com.wkodate.leetcode.LC0242_ValidAnagram;

import java.util.Arrays;

public class Solution {

    public boolean isAnagram(String s, String t) {
        String[] sarr = s.split("");
        String[] tarr = t.split("");
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        String ssorted = String.join("", sarr);
        String tsorted = String.join("", tarr);
        return ssorted.equals(tsorted);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
        System.out.println(solution.isAnagram("", "a"));
    }

}
