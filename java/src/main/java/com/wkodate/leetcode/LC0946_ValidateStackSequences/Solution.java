package com.wkodate.leetcode.LC0946_ValidateStackSequences;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for (int j = 0; j < popped.length; j++) {
            if (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                continue;
            }
            while (i <= pushed.length - 1) {
                stack.push(pushed[i]);
                i++;
                if(!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    break;
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        // false
        System.out.println(s.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

}
