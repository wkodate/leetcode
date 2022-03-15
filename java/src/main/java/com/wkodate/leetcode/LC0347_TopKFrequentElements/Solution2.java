package com.wkodate.leetcode.LC0347_TopKFrequentElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Solution2 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                Comparator.comparingInt(Entry::getValue));
        for (Entry<Integer, Integer> e : map.entrySet()) {
            heap.add(e);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(heap.poll().getKey());
        }
        Collections.reverse(list);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 1,2
        System.out.println(Arrays.toString(s.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2)));
        // 1
        System.out.println(Arrays.toString(s.topKFrequent(new int[] { 1 }, 1)));
    }

}
