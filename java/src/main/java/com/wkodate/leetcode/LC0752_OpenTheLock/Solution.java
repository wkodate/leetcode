package com.wkodate.leetcode.LC0752_OpenTheLock;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        visited.addAll(Arrays.asList(deadends));
        if (visited.contains("0000")) {
            return -1;
        }
        Deque<String> queue = new ArrayDeque<>();
        queue.offer("0000");
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String numStr = queue.poll();
                List<String> addends = new ArrayList<>();
                addends.add(numStr);
                for (int j = 0; j < 4; j++) {
                    StringBuilder sb1 = new StringBuilder(numStr.substring(0, j));
                    StringBuilder sb2 = new StringBuilder(numStr.substring(0, j));
                    if (numStr.charAt(j) == '0') {
                        sb1.append(9);
                    } else {
                        sb1.append(numStr.charAt(j) - '0' - 1);
                    }
                    if (numStr.charAt(j) == '9') {
                        sb2.append(9);
                    } else {
                        sb2.append(numStr.charAt(j) - '0' + 1);
                    }
                    sb1.append(numStr.substring(j + 1));
                    sb2.append(numStr.substring(j + 1));
                    addends.add(sb1.toString());
                    addends.add(sb2.toString());
                }

                for (String addend : addends) {
                    if (addend.equals(target)) {
                        return count;
                    }
                    if (!visited.contains(addend)) {
                        visited.add(addend);
                        queue.add(addend);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        // 1
        System.out.println(s.openLock(new String[]{"8888"}, "0009"));
        //// -1
        System.out.println(s.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
        //// -1
        System.out.println(s.openLock(new String[]{"0000"}, "8888"));
    }

}
