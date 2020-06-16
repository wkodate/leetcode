package com.wkodate.leetcode.LC0468_ValidateIPAddress;

public class Solution {

    public String validIPAddress(String IP) {
        if (IP.contains(".")) {
            if (IP.startsWith(".") || IP.endsWith(".")) {
                return "Neither";
            }
            String[] address = IP.split("\\.");
            if (address.length != 4) {
                return "Neither";
            }
            for (int i = 0; i < address.length; i++) {
                if (!address[i].matches("\\d+(\\.\\d+)?")
                    || address[i].length() > 3
                    || address[i].startsWith("0") && address[i].length() > 1) {
                    return "Neither";
                }
                int num = Integer.parseInt(address[i]);
                if (num < 0 || num > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if (IP.contains(":")) {
            if (IP.startsWith(":") || IP.endsWith(":")) {
                return "Neither";
            }
            String[] address = IP.split(":");
            if (address.length != 8) {
                return "Neither";
            }
            for (int i = 0; i < address.length; i++) {
                if ("".equals(address[i])
                    || address[i].length() > 4
                    || !address[i].matches("[0-9a-fA-F]+")) {
                    return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // IPv4
        System.out.println(s.validIPAddress("172.16.254.1"));
        // IPv6
        System.out.println(s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        // Neither
        System.out.println(s.validIPAddress("256.256.256.256"));
        // Neither
        System.out.println(s.validIPAddress("1.1.1.1."));
        // Neither
        System.out.println(s.validIPAddress("01.01.01.01"));
        // Neither
        System.out.println(s.validIPAddress("0.0.0.-0"));
        // Neither
        System.out.println(s.validIPAddress("1e1.4.5.6"));
        // Neither
        System.out.println(s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        // Neither
        System.out.println(s.validIPAddress("2001:0db8:85a3:00000:0:8A2E:0370:7334"));
        // Neither
        System.out.println(s.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
    }

}
