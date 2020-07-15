package com.wkodate.leetcode.LC0151_ReverseWordsInAString;

import java.util.StringJoiner;

public class Solution2 {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[words.length - 1 - i];
            if (word.isEmpty()) {
                continue;
            }
            sj.add(word);
        }
        return sj.toString();
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // world! hello
        System.out.println(s.reverseWords("  hello world!  "));
        // example good a
        System.out.println(s.reverseWords("a good   example"));
        // blue is sky the
        System.out.println(s.reverseWords("the sky is blue"));
    }

}
