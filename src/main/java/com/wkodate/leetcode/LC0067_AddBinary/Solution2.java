package com.wkodate.leetcode.LC0067_AddBinary;

public class Solution2 {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int alen = a.length() - 1;
        int blen = b.length() - 1;
        int carry = 0;
        while (alen >= 0 || blen >= 0) {
            int sum = carry;
            if (blen >= 0) {
                sum += b.charAt(blen--) - '0';
            }
            if (alen >= 0) {
                sum += a.charAt(alen--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        // 100
        System.out.println(solution.addBinary("11", "01"));
        // 10101
        System.out.println(solution.addBinary("1010", "1011"));
        System.out.println(solution.addBinary(
                "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

}
