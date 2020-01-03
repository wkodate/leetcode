package com.wkodate.leetcode.LC0682_BaseballGame;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int calPoints(String[] ops) {
        int score = 0;
        Deque<String> stack = new ArrayDeque<>();
        for (String op : ops) {
            if ("+".equals(op)) {
                int first = Integer.parseInt(stack.pop());
                int second = Integer.parseInt(stack.peek());
                int sum = first + second;
                score += sum;
                stack.push(String.valueOf(first));
                stack.push(String.valueOf(sum));
            } else if ("D".equals(op)) {
                int first = Integer.parseInt(stack.peek());
                int doubled = first * 2;
                score += doubled;
                stack.push(String.valueOf(doubled));
            } else if ("C".equals(op)) {
                int first = Integer.parseInt(stack.pop());
                score -= first;
            } else {
                score += Integer.parseInt(op);
                stack.push(op);
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 30
        System.out.println(s.calPoints(new String[]{"5", "2", "C", "D", "+"}));
        // 27
        System.out.println(s.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }

}
