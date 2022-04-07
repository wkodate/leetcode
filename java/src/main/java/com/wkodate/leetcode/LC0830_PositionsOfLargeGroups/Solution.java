package com.wkodate.leetcode.LC0830_PositionsOfLargeGroups;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<Integer> largeGroupList(int start, int end) {
        List<Integer> largeGroup = new ArrayList<>();
        largeGroup.add(start);
        largeGroup.add(end);
        return largeGroup;
    }

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int startIdx = 0;
        int len = 1;
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) == S.charAt(i + 1)) {
                len++;
                continue;
            }
            if (len >= 3) {
                ans.add(largeGroupList(startIdx, i));
            }
            startIdx = i + 1;
            len = 1;
        }
        if (len >= 3) {
            ans.add(largeGroupList(startIdx, S.length() - 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[3,6]]
        List<List<Integer>> ans1 = s.largeGroupPositions("abbxxxxzzy");
        for (List<Integer> a : ans1) {
            System.out.println(a.toString());
        }
        // []
        List<List<Integer>> ans2 = s.largeGroupPositions("abc");
        for (List<Integer> a : ans2) {
            System.out.println(a.toString());
        }
        // [[3,5],[6,9],[12,14]]
        List<List<Integer>> ans3 = s.largeGroupPositions("abcdddeeeeaabbbcd");
        for (List<Integer> a : ans3) {
            System.out.println(a.toString());
        }
        // [[0,2]]
        List<List<Integer>> ans4 = s.largeGroupPositions("aaa");
        for (List<Integer> a : ans4) {
            System.out.println(a.toString());
        }
    }

}
