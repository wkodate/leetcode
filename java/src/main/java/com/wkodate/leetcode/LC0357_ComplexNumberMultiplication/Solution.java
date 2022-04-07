package com.wkodate.leetcode.LC0357_ComplexNumberMultiplication;

public class Solution {

    public String complexNumberMultiply(String a, String b) {
        String[] aarr = a.split("\\+", 2);
        String[] barr = b.split("\\+", 2);
        int ar = Integer.parseInt(aarr[0]);
        int br = Integer.parseInt(barr[0]);
        int ai = Integer.parseInt(aarr[1].replaceAll("i", ""));
        int bi = Integer.parseInt(barr[1].replaceAll("i", ""));
        StringBuilder ans = new StringBuilder();
        ans.append(ar * br - ai * bi);
        ans.append("+");
        ans.append(ar * bi + br * ai);
        ans.append("i");
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "0+2i"
        System.out.println(s.complexNumberMultiply("1+1i", "1+1i"));
        // "0+-2i"
        System.out.println(s.complexNumberMultiply("1+-1i", "1+-1i"));
    }

}
