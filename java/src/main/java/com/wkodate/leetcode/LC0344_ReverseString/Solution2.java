package com.wkodate.leetcode.LC0344_ReverseString;

public class Solution2 {

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.reverseString(new char[] { 'h', 'e', 'l', 'l', 'o' });
        s.reverseString(new char[] { 'H', 'a', 'n', 'n', 'a', 'h' });
    }

}
