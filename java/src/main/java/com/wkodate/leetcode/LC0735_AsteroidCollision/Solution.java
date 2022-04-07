package com.wkodate.leetcode.LC0735_AsteroidCollision;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            if (asteroids[i] > 0 || stack.isEmpty()) {
                stack.push(asteroids[i]);
                continue;
            }
            while (true) {
                int latest = stack.pop();
                if (latest < 0) {
                    stack.push(latest);
                    stack.push(asteroids[i]);
                    break;
                }
                if (Math.abs(latest) == Math.abs(asteroids[i])) {
                    break;
                } else if (Math.abs(latest) > Math.abs(asteroids[i])) {
                    stack.push(latest);
                    break;
                } else if (stack.isEmpty()) {
                    stack.push(asteroids[i]);
                    break;
                }
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[ans.length - 1 - i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [-2,-2,-2]
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{1, -2, -2, -2})));
        // [1]
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{1})));
        // [-2,-1,1,2]
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{-2, -1, 1, 2})));
        // [5,10]
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{5, 10, -5})));
        // []
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{8, -8})));
        // [10]
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{10, 2, -5})));
    }

}
