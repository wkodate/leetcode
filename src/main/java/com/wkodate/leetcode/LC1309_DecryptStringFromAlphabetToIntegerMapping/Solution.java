package com.wkodate.leetcode.LC1309_DecryptStringFromAlphabetToIntegerMapping;

public class Solution {

    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 2 && s.charAt(i + 2) == '#') {
                sb.append((char) (Integer.parseInt(s.substring(i, i + 2)) + 'a' - 1));
                i += 2;
            } else {
                sb.append((char) (Character.getNumericValue(s.charAt(i)) + 'a' - 1));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // jkab
        System.out.println(s.freqAlphabets("10#11#12"));
        // acz
        System.out.println(s.freqAlphabets("1326#"));
        // y
        System.out.println(s.freqAlphabets("25#"));
        // abcdefghijklmnopqrstuvwxyz
        System.out.println(s.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }

}
