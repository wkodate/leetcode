package com.wkodate.leetcode.LC0844_BackspaceStringCompare;

public class Solution {

    private String type(String str) {
        int cur = 0;
        while (cur < str.length()) {
            char c = str.charAt(cur);
            if (c == '#') {
                StringBuilder sb = new StringBuilder();
                sb.append(str, 0, Math.max(0, cur - 1));
                sb.append(str.substring(Math.max(0, cur + 1)));
                str = sb.toString();
                cur = Math.max(0, cur - 1);
                continue;
            }
            cur++;
        }
        return str;
    }

    public boolean backspaceCompare(String S, String T) {
        S = type(S);
        T = type(T);
        return S.equals(T);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
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
