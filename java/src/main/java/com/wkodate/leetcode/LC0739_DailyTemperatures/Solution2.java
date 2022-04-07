package com.wkodate.leetcode.LC0739_DailyTemperatures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution2 {

    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(Arrays.toString(s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

}
