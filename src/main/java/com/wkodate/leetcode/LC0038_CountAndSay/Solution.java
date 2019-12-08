package com.wkodate.leetcode.LC0038_CountAndSay;

public class Solution {

    public String countAndSay(int n) {
        int count = 1;
        String ans = "1";
        while (n != 1 && count < n) {
            String[] str = ans.split("");
            StringBuilder sb = new StringBuilder();
            int freq = 0;
            int value = Integer.parseInt(str[0]);
            for (String s : str) {
                if (String.valueOf(value).equals(s)) {
                    freq++;
                    continue;
                }
                sb.append(freq);
                sb.append(value);
                freq = 1;
                value = Integer.parseInt(s);
            }
            if (freq > 0) {
                sb.append(freq);
                sb.append(value);
            }
            ans = sb.toString();
            count++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(1));
        System.out.println(solution.countAndSay(2));
        System.out.println(solution.countAndSay(3));
        System.out.println(solution.countAndSay(4));
        System.out.println(solution.countAndSay(5));
        System.out.println(solution.countAndSay(6));
    }

}
