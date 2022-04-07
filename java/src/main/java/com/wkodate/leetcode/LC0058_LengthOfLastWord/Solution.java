package com.wkodate.leetcode.LC0058_LengthOfLastWord;

public class Solution {

    public int lengthOfLastWord(String s) {
        String[] sarr = s.split(" ");
        if (sarr.length == 0) {
            return 0;
        }
        return sarr[sarr.length - 1].length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.lengthOfLastWord("Hello World"));
        // 0
        System.out.println(s.lengthOfLastWord(" "));
    }

}
