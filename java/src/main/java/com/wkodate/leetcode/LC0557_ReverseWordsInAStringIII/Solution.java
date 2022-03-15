package com.wkodate.leetcode.LC0557_ReverseWordsInAStringIII;

import java.util.StringJoiner;

public class Solution {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringJoiner sj = new StringJoiner(" ");
        for (String word : words) {
            sj.add(new StringBuilder(word).reverse().toString());
        }
        return String.join(" ", sj.toString());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }

}
