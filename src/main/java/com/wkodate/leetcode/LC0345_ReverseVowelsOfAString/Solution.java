package com.wkodate.leetcode.LC0345_ReverseVowelsOfAString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public String reverseVowels(String s) {
        Character[] vowels = { 'a', 'i', 'u', 'e', 'o', 'A', 'I', 'U', 'E', 'O' };
        Set<Character> vowelSet = new HashSet<>(Arrays.asList(vowels));
        boolean[] isVowel = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (vowelSet.contains(s.charAt(i))) {
                isVowel[i] = true;
            }
        }
        StringBuilder ans = new StringBuilder();
        int j = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel[i]) {
                while (!isVowel[j]) {
                    j--;
                }
                ans.append(s.charAt(j--));
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // holle
        System.out.println(solution.reverseVowels("hello"));
        // leetcode
        System.out.println(solution.reverseVowels("leetcode"));
        // Aa
        System.out.println(solution.reverseVowels("aA"));
    }

}
