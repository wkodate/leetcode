package com.wkodate.leetcode.LC1221_SplitAStringInBalancedStrings;

public class Solution {

    public int balancedStringSplit(String s) {
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                cnt--;
            } else {
                cnt++;
            }
            if (cnt == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.balancedStringSplit("RLRRLLRLRL"));
        // 3
        System.out.println(s.balancedStringSplit("RLLLLRRRLR"));
        // 1
        System.out.println(s.balancedStringSplit("LLLLRRRR"));
        // 2
        System.out.println(s.balancedStringSplit("RLRRRLLRLL"));

    }

}
