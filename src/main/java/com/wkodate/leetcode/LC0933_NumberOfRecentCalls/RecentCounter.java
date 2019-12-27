package com.wkodate.leetcode.LC0933_NumberOfRecentCalls;

import java.util.ArrayList;
import java.util.List;

public class RecentCounter {

    List<Integer> list;

    public RecentCounter() {
        this.list = new ArrayList<>();
    }

    public int ping(int t) {
        list.add(t);
        int left = 0;
        int right = list.size() - 1;
        int target = t - 3000;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target > list.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return list.size() - left;
    }

    public static void main(String[] args) {
        RecentCounter s = new RecentCounter();
        // 1
        System.out.println(s.ping(1));
        // 2
        System.out.println(s.ping(100));
        // 3
        System.out.println(s.ping(3001));
        // 3
        System.out.println(s.ping(3002));
    }

}
