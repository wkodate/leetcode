package com.wkodate.leetcode.LC0402_RemoveKDigits;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == k) {
            return "0";
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        for (int i = 0; i < k; i++) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "33"
        System.out.println(s.removeKdigits("5337", 2));
        // "11"
        System.out.println(s.removeKdigits("112", 1));
        // "0"
        System.out.println(s.removeKdigits("10", 2));
        // "200"
        System.out.println(s.removeKdigits("10200", 1));
        // "1219"
        System.out.println(s.removeKdigits("1432219", 3));
    }

}
