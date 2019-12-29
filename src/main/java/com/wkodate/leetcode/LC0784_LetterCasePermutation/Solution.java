package com.wkodate.leetcode.LC0784_LetterCasePermutation;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public void dfs(char[] c, List<String> ans, int pos) {
        if (pos == c.length) {
            ans.add(new String(c));
            return;
        }
        if (c[pos] >= '0' && c[pos] <= '9') {
            dfs(c, ans, pos + 1);
            return;
        }
        c[pos] = Character.toLowerCase(c[pos]);
        dfs(c, ans, pos + 1);
        c[pos] = Character.toUpperCase(c[pos]);
        dfs(c, ans, pos + 1);
    }

    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        List<String> ans = new LinkedList<>();
        dfs(S.toCharArray(), ans, 0);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCasePermutation("a1b2").toString());
    }

}
