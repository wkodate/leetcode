package com.wkodate.leetcode.LC0210_CourseScheduleII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private static final int WHITE = 1;
    private static final int GRAY = 2;
    private static final int BLACK = 3;

    private boolean isPossible;
    private Map<Integer, Integer> color;
    private Map<Integer, List<Integer>> adjList;
    private List<Integer> topologicalOrder;

    private void init(int numCourses) {
        isPossible = true;
        color = new HashMap<>();
        adjList = new HashMap<>();
        topologicalOrder = new ArrayList<>();
        // By default all vertces are WHITE
        for (int i = 0; i < numCourses; i++) {
            color.put(i, WHITE);
        }
    }

    private void dfs(int node) {
        // Don't recurse further if we found a cycle already
        if (!isPossible) {
            return;
        }
        // Start the recursion
        color.put(node, GRAY);
        // Traverse on neighboring vertices
        for (Integer neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (color.get(neighbor) == WHITE) {
                dfs(neighbor);
            } else if (this.color.get(neighbor) == GRAY) {
                // An edge to a GRAY vertex represents a cycle
                isPossible = false;
            }
        }
        // Recursion ends. We mark it as black
        this.color.put(node, BLACK);
        this.topologicalOrder.add(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        init(numCourses);
        // Create the adjacency list representation of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            adjList.put(src, lst);
        }
        // If the node is unprocessed, then call dfs on it.
        for (int i = 0; i < numCourses; i++) {
            if (color.get(i) == WHITE) {
                dfs(i);
            }
        }
        if (!isPossible) {
            return new int[] {};
        }
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = topologicalOrder.get(numCourses - i - 1);
        }
        return order;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,1,2,3] or [0,2,1,3]
        System.out.println(Arrays.toString(s.findOrder(4, new int[][] {
                { 1, 0 },
                { 2, 0 },
                { 3, 1 },
                { 3, 2 },
                })));
        // [0,1]
        System.out.println(Arrays.toString(s.findOrder(2, new int[][] { { 1, 0 } })));
    }
}