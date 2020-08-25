package com.wkodate.leetcode.LC0824_GoatLatin;

import java.util.StringJoiner;

public class Solution2 {

    public String toGoatLatin(String S) {
        String[] s = S.split(" ");
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < s.length; i++) {
            String word = s[i];
            StringBuilder sb = new StringBuilder();
            char head = Character.toLowerCase(word.charAt(0));
            if (head == 'a' || head == 'i' || head == 'u' || head == 'e' || head == 'o') {
                sb.append(word);
                sb.append("ma");
            } else {
                sb.append(word.substring(1));
                sb.append(word.substring(0, 1));
                sb.append("ma");
            }
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            sj.add(sb);
        }
        return sj.toString();
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.toGoatLatin("I have solved Goat Latin"));
        System.out.println(s.toGoatLatin("I speak Goat Latin"));
        System.out.println(s.toGoatLatin("The quick brown fox jumped over the lazy dog"));
        System.out.println(s.toGoatLatin("a"));
    }

}
