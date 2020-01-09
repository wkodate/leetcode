package com.wkodate.leetcode.LC0925_LongPressedName;

public class Solution {

    public boolean isLongPressedName(String name, String typed) {
        int typedIdx = 0;
        for (int i = 0; i < name.length(); i++) {
            char cname = name.charAt(i);
            boolean found = false;
            for (int j = typedIdx; j < typed.length(); j++) {
                char ctyped = typed.charAt(typedIdx);
                typedIdx++;
                if (ctyped == cname) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isLongPressedName("alex", "aaleex"));
        // false
        System.out.println(s.isLongPressedName("saeed", "ssaaedd"));
        // true
        System.out.println(s.isLongPressedName("leelee", "lleeelee"));
        // true
        System.out.println(s.isLongPressedName("laiden", "laiden"));
        // false
        System.out.println(s.isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz"));
    }

}
