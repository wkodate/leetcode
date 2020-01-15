package com.wkodate.leetcode.LC0443_StringCompression;

import java.util.Arrays;

public class Solution {

    public int compress(char[] chars) {
        char target = '0';
        int cur = 1;
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                target = chars[i];
                continue;
            }
            if (chars[i] == target) {
                count++;
            } else {
                if (count >= 2) {
                    String strCount = String.valueOf(count);
                    for (int j = 0; j < strCount.length(); j++) {
                        chars[cur++] = strCount.charAt(j);
                    }
                }
                target = chars[i];
                chars[cur++] = target;
                count = 1;
            }
        }
        if (count >= 2) {
            String strCount = String.valueOf(count);
            for (int j = 0; j < strCount.length(); j++) {
                chars[cur++] = strCount.charAt(j);
            }
        }
        System.out.println(Arrays.toString(chars));
        return cur;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        // 1
        System.out.println(s.compress(new char[]{'a'}));
        // 4
        System.out.println(s.compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
        // 6
        System.out.println(s.compress(new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'}));
    }

}
