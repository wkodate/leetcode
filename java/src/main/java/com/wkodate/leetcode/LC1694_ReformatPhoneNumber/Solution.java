package com.wkodate.leetcode.LC1694_ReformatPhoneNumber;

public class Solution {

    public String reformatNumber(String number) {
        number = number.replaceAll("-", "").replaceAll(" ", "");
        StringBuilder sb = new StringBuilder();
        while (number.length() > 4) {
            if (sb.length() != 0) {
                sb.append("-");
            }
            sb.append(number, 0, 3);
            number = number.substring(3);
        }
        if (number.length() == 4) {
            if (sb.length() != 0) {
                sb.append("-");
            }
            sb.append(number, 0, 2);
            sb.append("-");
            sb.append(number, 2, 4);
        } else if (number.length() >= 2) {
            if (sb.length() != 0) {
                sb.append("-");
            }
            sb.append(number);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 123-456
        System.out.println(s.reformatNumber("1-23-45 6"));
        // 123-45-67
        System.out.println(s.reformatNumber("123 4-567"));
        // 123-456-78
        System.out.println(s.reformatNumber("123 4-5678"));
        // 12
        System.out.println(s.reformatNumber("12"));
        // 175-229-353-94-75
        System.out.println(s.reformatNumber("--17-5 229 35-39475 "));
    }

}
