package com.wkodate.leetcode.LC0621_TaskScheduler;

public class Solution {

    public int leastInterval(char[] tasks, int n) {
        int[] numTasks = new int[26];
        int[] wait = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            numTasks[tasks[i] - 'A']++;
        }
        int cnt = 0;
        while (true) {
            int maxkey = -1;
            int maxval = 0;
            boolean finished = true;
            for (int i = 0; i < numTasks.length; i++) {
                if (numTasks[i] > 0) {
                    finished = false;
                    if (wait[i] == 0) {
                        if (numTasks[i] > maxval) {
                            maxkey = i;
                            maxval = numTasks[i];
                        }
                    }
                }
            }
            if (finished) {
                return cnt;
            }
            for (int i = 0; i < numTasks.length; i++) {
                if (i == maxkey) {
                    numTasks[i]--;
                    wait[i] += n;
                } else {
                    wait[i] = Math.max(wait[i] - 1, 0);
                }
            }
            cnt++;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 52
        System.out.println(s.leastInterval(new char[] {
                'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F',
                'G', 'G', 'H', 'H', 'I', 'I', 'J', 'J', 'K', 'K', 'L', 'L',
                'M', 'M', 'N', 'N', 'O', 'O', 'P', 'P', 'Q', 'Q', 'R', 'R',
                'S', 'S', 'T', 'T', 'U', 'U', 'V', 'V', 'W', 'W', 'X', 'X',
                'Y', 'Y', 'Z', 'Z'
        }, 2));
        // 8
        System.out.println(s.leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));
        // 6
        System.out.println(s.leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 0));
        // 16
        System.out.println(
                s.leastInterval(new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' }, 2));
    }

}
