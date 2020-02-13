package com.wkodate.leetcode.LC0279_PerfectSquares;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int numSquares(int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int base = queue.poll();
                for (int j = 1; j * j <= n; j++) {
                    int sum = base + j * j;
                    if (sum == n) {
                        return depth;
                    }
                    if (sum > n) {
                        break;
                    }
                    if (!visited.contains(sum)) {
                        queue.offer(sum);
                        visited.add(sum);
                    }
                }
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.numSquares(12));
        // 2
        System.out.println(s.numSquares(13));
        // 1
        System.out.println(s.numSquares(4));
    }

}
