package com.wkodate.leetcode.LC0020_ValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }
        Deque<String> queue = new ArrayDeque<>();
        String[] sarr = s.split("");
        for (String str : sarr) {
            if ("(".equals(str) || "[".equals(str) || "{".equals(str)) {
                queue.push(str);
            } else {
                if (queue.size() == 0) {
                    return false;
                }
                String par = queue.pop();
                if ("(".equals(par) && !")".equals(str)
                        || "[".equals(par) && !"]".equals(str)
                        || "{".equals(par) && !"}".equals(str)
                ) {
                    return false;
                }
            }
        }
        return queue.size() == 0;
    }

    public static void main(String[] args) {
    }

}
