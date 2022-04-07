package com.wkodate.leetcode.LC0771_JewelsAndStones;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int cnt = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 3
        System.out.println(s.numJewelsInStones("aA", "aAAbbbb"));
        // 0
        System.out.println(s.numJewelsInStones("z", "ZZ"));
    }

}
