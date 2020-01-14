package com.wkodate.leetcode.LC0541_ReverseStringII;

public class Solution {

    public String reverseStr(String s, int k) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i += k) {
            String str;
            if (i + k < s.length()) {
                str = s.substring(i, i + k);
            } else {
                str = s.substring(i);
            }
            if (i % (2 * k) < k) {
                ans.append(new StringBuilder(str).reverse().toString());
            } else {
                ans.append(str);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseStr("abcdefg", 2));
    }

}
