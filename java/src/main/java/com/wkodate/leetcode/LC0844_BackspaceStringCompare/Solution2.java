package com.wkodate.leetcode.LC0844_BackspaceStringCompare;

public class Solution2 {

    private String backspaceString(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char cs = S.charAt(i);
            if (cs == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                continue;
            }
            sb.append(cs);
        }
        return sb.toString();
    }

    public boolean backspaceCompare(String S, String T) {
        return backspaceString(S).equals(backspaceString(T));
    }


    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // true
        System.out.println(s.backspaceCompare("ab#c", "ad#c"));
        // true
        System.out.println(s.backspaceCompare("ab##", "c#d#"));
        // true
        System.out.println(s.backspaceCompare("a##c", "#a#c"));
        // false
        System.out.println(s.backspaceCompare("a#c", "b"));
    }

}
