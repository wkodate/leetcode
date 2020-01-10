package com.wkodate.leetcode.LC0917_ReverseOnlyLetters;

public class Solution {

    public String reverseOnlyLetters(String S) {
        StringBuilder reversed = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); i++) {
            char ci = S.charAt(i);
            if (Character.isLetter(ci)) {
                while (true) {
                    char cj = S.charAt(j);
                    if (Character.isLetter(cj)) {
                        reversed.append(cj);
                        break;
                    }
                    j--;
                }
                j--;
            } else {
                reversed.append(ci);
            }
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // dc-ba
        System.out.println(s.reverseOnlyLetters("ab-cd"));
        // j-Ih-gfE-dCba
        System.out.println(s.reverseOnlyLetters("a-bC-dEf-ghIj"));
        // Qedo1ct-eeLg=ntse-T!
        System.out.println(s.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

}
