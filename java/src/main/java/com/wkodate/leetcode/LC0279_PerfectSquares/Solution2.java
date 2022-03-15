package com.wkodate.leetcode.LC0279_PerfectSquares;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution2 {

    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int idx = 1;
        while (idx * idx <= n) {
            squares.add(idx * idx);
            idx++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        int min = n;
        int cnt = 0;
        boolean found = false;
        while (!queue.isEmpty()) {
            cnt++;
            if (cnt >= min) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                for (int j = 0; j < squares.size(); j++) {
                    if (squares.get(j) > num) {
                        continue;
                    }
                    if (squares.get(j) == num) {
                        min = Math.min(min, cnt);
                        found = true;
                        break;
                    }
                    queue.add(num - squares.get(j));
                }
                if (found) {
                    queue.clear();
                    break;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 3
        System.out.println(s.numSquares(12));
        // 2
        System.out.println(s.numSquares(13));
        // 3
        System.out.println(s.numSquares(43));
        // 4
        System.out.println(s.numSquares(111));
        // 3
        System.out.println(s.numSquares(114));
        // 3
        System.out.println(s.numSquares(110));
    }

}
