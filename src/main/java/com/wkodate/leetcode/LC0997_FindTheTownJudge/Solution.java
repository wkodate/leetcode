package com.wkodate.leetcode.LC0997_FindTheTownJudge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int findJudge(int N, int[][] trust) {
        Map<Integer, List<Integer>> trustMap = new HashMap<>();
        Map<Integer, List<Integer>> trustedMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            trustMap.put(i, new ArrayList<>());
            trustedMap.put(i, new ArrayList<>());
        }
        for (int i = 0; i < trust.length; i++) {
            List<Integer> trustList = trustMap.get(trust[i][0]);
            trustList.add(trust[i][1]);
            trustMap.put(trust[i][0], trustList);
            List<Integer> trustedList = trustedMap.get(trust[i][1]);
            trustedList.add(trust[i][0]);
            trustedMap.put(trust[i][1], trustedList);
        }
        for (Integer key : trustedMap.keySet()) {
            if (trustedMap.get(key).size() >= N - 1) {
                if (trustMap.get(key).isEmpty()) {
                    return key;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.findJudge(2, new int[][] { { 1, 2 } }));
        // 3
        System.out.println(s.findJudge(3, new int[][] { { 1, 3 }, { 2, 3 } }));
        // -1
        System.out.println(s.findJudge(3, new int[][] { { 1, 3 }, { 2, 3 }, { 3, 1 } }));
        // -1
        System.out.println(s.findJudge(3, new int[][] { { 1, 2 }, { 2, 3 } }));
        // 3
        System.out.println(s.findJudge(4, new int[][] { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } }));
    }

}
