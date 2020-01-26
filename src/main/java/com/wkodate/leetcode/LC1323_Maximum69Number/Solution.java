package com.wkodate.leetcode.LC1323_Maximum69Number;

public class Solution {

    public int maximum69Number(int num) {
        String ansStr = String.valueOf(num).replaceFirst("6", "9");
        return Integer.parseInt(ansStr);

        //String[] numsStr = String.valueOf(num).split("");
        //for (String numStr : numsStr) {

        //}

        //Arrays.sort(numStr, Collections.reverseOrder());

        /**
         for (int i = 0; i < numStr.length; i++) {
         ans += Integer.parseInt(numStr[i]) * Math.pow(10, numStr.length - i - 1);
         }
         */
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 9969
        System.out.println(s.maximum69Number(9669));
        // 9999
        System.out.println(s.maximum69Number(9996));
        // 9999
        System.out.println(s.maximum69Number(9999));
    }

}
