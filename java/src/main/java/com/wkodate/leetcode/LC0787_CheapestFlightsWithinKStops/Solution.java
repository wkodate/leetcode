package com.wkodate.leetcode.LC0787_CheapestFlightsWithinKStops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {

    private Map<Integer, List<int[]>> createGraph(int[][] flights) {
        // direct stops + cost to reach that stop
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[] { flight[1], flight[2] });
        }
        return graph;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // initialize the minPathCost with Integer.MAX_VALUE
        int minPathCost = Integer.MAX_VALUE;
        // create graph
        Map<Integer, List<int[]>> graph = createGraph(flights);

        int step = 0;
        // save next stop with the cost till that stop
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { src, 0 });
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] currentStop = q.poll();
                if (currentStop[0] == dst) {
                    minPathCost = Math.min(minPathCost, currentStop[1]);
                }
                // if no roots from that stop continue
                if (!graph.containsKey(currentStop[0])) {
                    continue;
                }
                for (int[] flight : graph.get(currentStop[0])) {
                    // cost + current flight cost > minPathCost discard that path ~ pruning
                    if (currentStop[1] + flight[1] > minPathCost) {
                        continue;
                    }
                    q.add(new int[] { flight[0], currentStop[1] + flight[1] });
                }
            }
            // once we crossed K stops and not reached to dst break;
            if (step++ > K) {
                break;
            }
        }

        return minPathCost == Integer.MAX_VALUE ? -1 : minPathCost;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(
                s.findCheapestPrice(5, new int[][] {
                        { 0, 1, 5 }, { 1, 2, 5 }, { 0, 3, 2 }, { 3, 1, 2 }, { 1, 4, 1 }, { 4, 2, 1 }
                }, 0, 2, 2));
        // 200
        System.out.println(
                s.findCheapestPrice(3, new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } }, 0, 2, 1));
        // 500
        System.out.println(
                s.findCheapestPrice(3, new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } }, 0, 2, 0));
    }

}
