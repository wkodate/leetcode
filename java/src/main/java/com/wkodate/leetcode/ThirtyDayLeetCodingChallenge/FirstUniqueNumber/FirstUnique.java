package com.wkodate.leetcode.ThirtyDayLeetCodingChallenge.FirstUniqueNumber;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class FirstUnique {

    Map<Integer, Integer> map;
    Deque<Integer> uq;

    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        uq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            uq.add(nums[i]);
        }
    }

    public int showFirstUnique() {
        while (!uq.isEmpty()) {
            int num = uq.peek();
            if (map.get(num) > 1) {
                uq.poll();
                continue;
            }
            return num;
        }
        return -1;
    }

    public void add(int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
        uq.add(value);
    }

    public static void main(String[] args) {
        FirstUnique fu = new FirstUnique(new int[] { 2, 3, 5 });
        // 2
        System.out.println(fu.showFirstUnique());
        fu.add(5);
        // 2
        System.out.println(fu.showFirstUnique());
        fu.add(2);
        // 3
        System.out.println(fu.showFirstUnique());
        fu.add(3);
        // -1
        System.out.println(fu.showFirstUnique());

        System.out.println("");
        FirstUnique fu2 = new FirstUnique(new int[] { 7, 7, 7, 7, 7, 7 });
        // -1
        System.out.println(fu2.showFirstUnique());
        fu2.add(7);
        fu2.add(3);
        fu2.add(3);
        fu2.add(7);
        fu2.add(17);
        // 17
        System.out.println(fu2.showFirstUnique());

        System.out.println("");
        FirstUnique fu3 = new FirstUnique(new int[] { 809 });
        // 809
        System.out.println(fu3.showFirstUnique());
        fu3.add(809);
        // -1
        System.out.println(fu3.showFirstUnique());
    }
}
