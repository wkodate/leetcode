package com.wkodate.leetcode.LC0476_NumberComplement;

public class Solution {

    public int findComplement(int num) {
        char[] binary = Integer.toString(num, 2).toCharArray();
        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == '0') {
                binary[i] = '1';
                continue;
            }
            binary[i] = '0';
        }
        return Integer.parseInt(String.valueOf(binary), 2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.findComplement(5));
        // 0
        System.out.println(s.findComplement(1));
    }

}
