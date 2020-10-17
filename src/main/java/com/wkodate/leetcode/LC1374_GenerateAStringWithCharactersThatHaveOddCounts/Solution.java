package com.wkodate.leetcode.LC1374_GenerateAStringWithCharactersThatHaveOddCounts;

public class Solution {

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append("a");
        }
        if (n % 2 == 0) {
            sb.append("b");
        } else {
            sb.append("a");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // pppz
        System.out.println(s.generateTheString(4));
        // xy
        System.out.println(s.generateTheString(2));
        // holasss
        System.out.println(s.generateTheString(7));
    }

}
