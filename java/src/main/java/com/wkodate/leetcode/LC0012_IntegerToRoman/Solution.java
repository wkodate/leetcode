package com.wkodate.leetcode.LC0012_IntegerToRoman;

public class Solution {

    private int n;

    private String[][] symbols = {
            { "M", "1000" },
            { "D", "500" },
            { "C", "100" },
            { "L", "50" },
            { "X", "10" },
            { "V", "5" },
            { "I", "1" },
            };

    private String toRomanString(String sym, int val) {
        StringBuilder sb = new StringBuilder();
        while (n / val > 0) {
            sb.append(sym);
            n -= val;
        }
        return sb.toString();
    }

    private String convertFourAndNine(String roman) {
        roman = roman.replaceAll("DCCCC", "CM");
        roman = roman.replaceAll("CCCC", "CD");
        roman = roman.replaceAll("LXXXX", "XC");
        roman = roman.replaceAll("XXXX", "XL");
        roman = roman.replaceAll("VIIII", "IX");
        roman = roman.replaceAll("IIII", "IV");
        return roman;
    }

    public String intToRoman(int num) {
        n = num;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < symbols.length; i++) {
            sb.append(toRomanString(symbols[i][0], Integer.parseInt(symbols[i][1])));
        }
        for (int i = 0; i < n; i++) {
            sb.append('I');
        }
        return convertFourAndNine(sb.toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // III
        System.out.println(s.intToRoman(3));
        // IV
        System.out.println(s.intToRoman(4));
        // IX
        System.out.println(s.intToRoman(9));
        // LVIII
        System.out.println(s.intToRoman(58));
        // MCMXCIV
        System.out.println(s.intToRoman(1994));
    }

}
