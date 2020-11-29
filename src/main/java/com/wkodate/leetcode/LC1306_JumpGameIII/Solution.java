package com.wkodate.leetcode.LC1306_JumpGameIII;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int idx = queue.poll();
                if (arr[idx] == 0) {
                    return true;
                }
                int pos1 = idx + arr[idx];
                int pos2 = idx - arr[idx];
                if (pos1 < arr.length && !visited[pos1]) {
                    queue.add(pos1);
                    visited[pos1] = true;
                }
                if (pos2 >= 0 && !visited[pos2]) {
                    queue.add(pos2);
                    visited[pos2] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
        // true
        System.out.println(s.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0));
        // false
        System.out.println(s.canReach(new int[]{3, 0, 2, 1, 2}, 2));
    }

}
