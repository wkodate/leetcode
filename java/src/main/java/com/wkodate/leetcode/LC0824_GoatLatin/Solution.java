package com.wkodate.leetcode.LC0824_GoatLatin;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class Solution {

    public String toGoatLatin(String S) {
        Set<Character> set = new HashSet<>();
        for (char c : new char[]{'a', 'i', 'u', 'e', 'o', 'A', 'I', 'U', 'E', 'O'}) {
            set.add(c);
        }
        String[] words = S.split(" ");
        StringJoiner ans = new StringJoiner(" ");
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            if (set.contains(words[i].charAt(0))) {
                sb.append(words[i]);
            } else {
                sb.append(words[i].substring(1));
                sb.append(words[i], 0, 1);
            }
            sb.append("ma");
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            ans.add(sb.toString());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // Imaa peaksmaaa oatGmaaaa atinLmaaaaa
        System.out.println(s.toGoatLatin("I speak Goat Latin"));
        // heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa
        System.out.println(s.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

}
