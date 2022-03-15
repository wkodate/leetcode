package com.wkodate.leetcode.LC1021_RemoveOutermostParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public String removeOuterParentheses(String S) {
        Deque<Character> outerStack = new ArrayDeque<>();
        Deque<Character> innerStack = new ArrayDeque<>();
        char[] ch = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (outerStack.isEmpty()) {
                outerStack.push(c);
            } else {
                if (innerStack.isEmpty()) {
                    if (outerStack.peek() == '(' && c == ')') {
                        outerStack.pop();
                    } else {
                        innerStack.push(c);
                        sb.append(c);
                    }
                } else {
                    sb.append(c);
                    if (innerStack.peek() == '(' && c == ')') {
                        innerStack.pop();
                    } else {
                        innerStack.push(c);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ()()()
        System.out.println(s.removeOuterParentheses("(()())(())"));
        // ()()()()(())
        System.out.println(s.removeOuterParentheses("(()())(())(()(()))"));
        // ""
        System.out.println(s.removeOuterParentheses("()()"));

    }

}
