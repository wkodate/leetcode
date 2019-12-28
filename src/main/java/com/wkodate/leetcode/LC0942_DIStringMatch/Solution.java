package com.wkodate.leetcode.LC0942_DIStringMatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[] diStringMatch(String S) {
        List<Integer> ans = new ArrayList<>();
        int dIdx = 0;
        int iIdx = S.length();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int count = 1;
            for (int j = i + 1; j < S.length(); j++) {
                if (c != S.charAt(j)) {
                    break;
                }
                count++;
                i++;
            }
            if (c == 'D') {
                if (ans.size() == 0) {
                    ans.add(iIdx--);
                }
                for (int j = dIdx + count - 1; j >= dIdx; j--) {
                    ans.add(j);
                }
                dIdx += count;
            } else {
                if (ans.size() == 0) {
                    ans.add(dIdx++);
                }
                for (int j = iIdx - count + 1; j <= iIdx; j++) {
                    ans.add(j);
                }
                iIdx -= count;
            }
        }
        int[] ansArr = new int[S.length() + 1];
        for (int i = 0; i < ansArr.length; i++) {
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,4,1,3,2]
        System.out.println(Arrays.toString(s.diStringMatch("IDID")));
        // [0,1,2,3]
        System.out.println(Arrays.toString(s.diStringMatch("III")));
        // [3,2,0,1]
        System.out.println(Arrays.toString(s.diStringMatch("DDI")));
        // [0, 1]
        System.out.println(Arrays.toString(s.diStringMatch("I")));
        // [1, 0]
        System.out.println(Arrays.toString(s.diStringMatch("D")));
    }

}
