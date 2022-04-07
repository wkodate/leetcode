package com.wkodate.leetcode.LC0394_DecodeString;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public String decodeString(String s) {
        if ("".equals(s)) {
            return "";
        }
        Deque<Integer> count = new ArrayDeque<>();
        Deque<String> result = new ArrayDeque<>();
        int i = 0;
        result.push("");
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int start = i;
                while (Character.isDigit(s.charAt(i + 1))) {
                    i++;
                }
                count.push(Integer.parseInt(s.substring(start, i + 1)));
            } else if (c == '[') {
                result.push("");
            } else if (c == ']') {
                String str = result.pop();
                StringBuilder sb = new StringBuilder();
                int times = count.pop();
                for (int j = 0; j < times; j++) {
                    sb.append(str);
                }
                result.push(result.pop() + sb.toString());
            } else {
                result.push(result.pop() + c);
            }
            i++;
        }
        return result.pop();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // aaabcbc
        System.out.println(s.decodeString("3[a]2[bc]"));
        // accaccacc
        System.out.println(s.decodeString("3[a2[c]]"));
        // abcabccdcdcdef
        System.out.println(s.decodeString("2[abc]3[cd]ef"));
        System.out.println(s.decodeString("10[a]3[b]"));
    }

}
