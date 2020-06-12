package com.wkodate.leetcode.LC0207_CourseSchedule;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<Integer>[] graph;
    private boolean[] visited;
    private boolean[] explored;

    private boolean isCyclic(int u) {
        visited[u] = true;
        for (Integer v : graph[u]) {
            if (!visited[v]) {
                if (isCyclic(v)) {
                    return true;
                }
            } else if (!explored[v]) {
                return true;
            }
        }
        // explored all the adjacent vertices for vertex "u" and thus marking "u" as explored
        explored[u] = true;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //  creating adjacency list representation of the graph
        graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        visited = new boolean[numCourses];
        explored = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCyclic(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(
                s.canFinish(8, new int[][] { { 1, 0 }, { 2, 6 }, { 1, 7 }, { 6, 4 }, { 7, 0 }, { 0, 5 } }));
        // true
        System.out.println(s.canFinish(3, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 } }));
        // true
        System.out.println(s.canFinish(3, new int[][] { { 1, 0 }, { 2, 1 } }));
        // false
        System.out.println(s.canFinish(3, new int[][] { { 0, 2 }, { 1, 2 }, { 2, 0 } }));
        // true
        System.out.println(s.canFinish(2, new int[][] { { 0, 1 } }));
        // true
        System.out.println(s.canFinish(2, new int[][] { { 1, 0 } }));
        // false
        System.out.println(s.canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
    }

}
