package com.wkodate.leetcode.LC1002_FindCommonCharacters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<String> commonChars(String[] A) {
        int[] commonCharCnt = new int[26];
        Arrays.fill(commonCharCnt, Integer.MAX_VALUE);
        for (int i = 0; i < A.length; i++) {
            int[] cnt = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                cnt[A[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < commonCharCnt.length; j++) {
                commonCharCnt[j] = Math.min(cnt[j], commonCharCnt[j]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < commonCharCnt.length; i++) {
            if (commonCharCnt[i] <= 0) {
                continue;
            }
            for (int j = 0; j < commonCharCnt[i]; j++) {
                ans.add(Character.toString((char) (i + 'a')));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["e","l","l"]
        System.out.println(s.commonChars(new String[]{"bella", "label", "roller"}));
        // ["c","o"]
        System.out.println(s.commonChars(new String[]{"cool", "lock", "cook"}));
    }

}
