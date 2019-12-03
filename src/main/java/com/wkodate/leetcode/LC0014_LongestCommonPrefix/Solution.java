package com.wkodate.leetcode.LC0014_LongestCommonPrefix;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String str0 = strs[0];
        for (int i = str0.length(); i >= 1; i--) {
            str0 = str0.substring(0, i);
            boolean matched = true;
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(str0)) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                return str0;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(solution.longestCommonPrefix(new String[]{""}));
    }

}
