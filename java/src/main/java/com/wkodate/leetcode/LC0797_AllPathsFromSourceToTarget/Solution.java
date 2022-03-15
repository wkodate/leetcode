package com.wkodate.leetcode.LC0797_AllPathsFromSourceToTarget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private Map<Integer, List<Integer>> map;
    private List<List<Integer>> ans;

    private void dfs(int n, List<Integer> path, int target) {
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            p.add(path.get(i));
        }
        p.add(n);
        if (n == target) {
            ans.add(p);
            return;
        }
        List<Integer> list = map.get(n);
        for (int i = 0; i < list.size(); i++) {
            dfs(list.get(i), p, target);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            map.put(i, new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                List<Integer> l = map.get(i);
                l.add(graph[i][j]);
                map.put(i, l);
            }
        }
        ans = new ArrayList<>();
        for (int i = 0; i < map.get(0).size(); i++) {
            List<Integer> l = new ArrayList<>();
            l.add(0);
            dfs(map.get(0).get(i), l, graph.length - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,1,3],[0,2,3]
        System.out.println(s.allPathsSourceTarget(new int[][] { { 1, 2 }, { 3 }, { 3 }, {} }));
        // [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
        System.out.println(s.allPathsSourceTarget(new int[][] {
                { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {}
        }));
        // [[0,3,6,7],[0,3,4,7],[0,3,4,6,7],[0,3,4,5,6,7],[0,1,4,7],[0,1,4,6,7],[0,1,4,5,6,7],[0,1,6,7],
        // [0,1,7],[0,1,2,4,7],[0,1,2,4,6,7],[0,1,2,4,5,6,7],[0,1,2,6,7],[0,1,2,3,6,7],[0,1,2,3,4,7],
        // [0,1,2,3,4,6,7],[0,1,2,3,4,5,6,7],[0,1,5,6,7]]
        System.out.println(s.allPathsSourceTarget(new int[][] {
                { 3, 1 },
                { 4, 6, 7, 2, 5 },
                { 4, 6, 3 },
                { 6, 4 },
                { 7, 6, 5 },
                { 6 },
                { 7 },
                {}
        }));
    }

}
