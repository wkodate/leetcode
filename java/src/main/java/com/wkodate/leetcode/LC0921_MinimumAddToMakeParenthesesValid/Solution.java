package com.wkodate.leetcode.LC0921_MinimumAddToMakeParenthesesValid;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int minAddToMakeValid(String S) {
        if ("".equals(S)) {
            return 0;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minAddToMakeValid("())"));
        // 3
        System.out.println(s.minAddToMakeValid("((("));
        // 0
        System.out.println(s.minAddToMakeValid("()"));
        // 4
        System.out.println(s.minAddToMakeValid("()))(("));
    }

}
