package com.wkodate.leetcode.LC1047_RemoveAllAdjacentDuplicatesInString;

public class Solution {

    public String removeDuplicates(String S) {
        String str = S;
        while (true) {
            int i = 0;
            while (i < str.length() - 1) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    String s = String.valueOf(str.charAt(i));
                    str = str.replaceFirst(s + s, "");
                    i = 0;
                    break;
                }
                i++;
            }
            if (i == str.length() - 1 || "".equals(str)) {
                break;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ca
        System.out.println(s.removeDuplicates("abbaca"));
        // ""
        System.out.println(s.removeDuplicates("aaaaaaaa"));
        // ba
        System.out.println(s.removeDuplicates("aababaab"));
    }

}
