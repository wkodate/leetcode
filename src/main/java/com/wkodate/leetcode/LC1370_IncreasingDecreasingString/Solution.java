package com.wkodate.leetcode.LC1370_IncreasingDecreasingString;

import java.util.Arrays;

public class Solution {

    public String sortString(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        boolean[] appended = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        while (true) {
            boolean finished = true;
            char lastAppended = 'a' - 1;
            for (int i = 0; i < s.length(); i++) {
                if (ch[i] > lastAppended && !appended[i]) {
                    lastAppended = ch[i];
                    sb.append(ch[i]);
                    appended[i] = true;
                    finished = false;
                }
            }
            lastAppended = 'z' + 1;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (ch[i] < lastAppended && !appended[i]) {
                    lastAppended = ch[i];
                    sb.append(ch[i]);
                    appended[i] = true;
                    finished = false;
                }
            }
            if (finished) {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // abccbaabccba
        System.out.println(s.sortString("aaaabbbbcccc"));
        // art
        System.out.println(s.sortString("rat"));
        // cdelotee
        System.out.println(s.sortString("leetcode"));
        // ggggggg
        System.out.println(s.sortString("ggggggg"));
        // ops
        System.out.println(s.sortString("spo"));
    }

}
