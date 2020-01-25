package com.wkodate.leetcode.LC1108_DefangingAnIPAddress;

public class Solution {

    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1[.]1[.]1[.]1
        System.out.println(s.defangIPaddr("1.1.1.1"));
    }

}
