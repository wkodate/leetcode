package com.wkodate.leetcode.LC0841_KeysAndRooms;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int current) {
        visited[current] = true;
        List<Integer> keys = rooms.get(current);
        for (int key : keys) {
            if (visited[key]) {
                continue;
            }
            dfs(rooms, visited, key);
        }

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> keys1 = new ArrayList<>();
        keys1.add(1);
        List<Integer> keys2 = new ArrayList<>();
        keys1.add(2);
        List<Integer> keys3 = new ArrayList<>();
        keys1.add(3);
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(keys1);
        rooms.add(keys2);
        rooms.add(keys3);
        rooms.add(new ArrayList<>());
        System.out.println(s.canVisitAllRooms(rooms));

        List<Integer> keys1_2 = new ArrayList<>();
        keys1_2.add(1);
        keys1_2.add(3);
        List<Integer> keys2_2 = new ArrayList<>();
        keys2_2.add(3);
        keys2_2.add(0);
        keys2_2.add(1);
        List<Integer> keys3_2 = new ArrayList<>();
        keys3_2.add(2);
        List<Integer> keys4_2 = new ArrayList<>();
        keys4_2.add(0);
        List<List<Integer>> rooms_2 = new ArrayList<>();
        rooms_2.add(keys1_2);
        rooms_2.add(keys2_2);
        rooms_2.add(keys3_2);
        rooms_2.add(keys4_2);
        rooms_2.add(new ArrayList<>());
        System.out.println(s.canVisitAllRooms(rooms_2));
    }

}
