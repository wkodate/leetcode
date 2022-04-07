package com.wkodate.leetcode.LC0763_PartitionLabels;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        int p = 0;
        int cnt = 0;
        for (int i = 0; i < S.length(); i++) {
            char ci = S.charAt(i);
            int lastMatched = i;
            cnt++;
            for (int j = i + 1; j < S.length(); j++) {
                char cj = S.charAt(j);
                if (ci == cj) {
                    lastMatched = j;
                    p = Math.max(j, p);
                }
            }
            if (i == lastMatched && i == p) {
                ans.add(cnt);
                p++;
                cnt = 0;
            }
        }
        if (cnt != 0) {
            ans.add(cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1.1.8]
        System.out.println(s.partitionLabels("vhaagbqkaq"));
        // [9,7,8]
        System.out.println(s.partitionLabels("ababcbacadefegdehijhklij"));
        // [9,1]
        System.out.println(s.partitionLabels("eaaaabaaec"));
    }

}
