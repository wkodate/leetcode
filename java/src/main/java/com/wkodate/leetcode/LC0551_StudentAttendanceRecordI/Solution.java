package com.wkodate.leetcode.LC0551_StudentAttendanceRecordI;

import java.util.Arrays;

public class Solution {

    public boolean checkRecord(String s) {
        if (s.contains("LLL")) {
            return false;
        }
        String[] sarr = s.split("");
        Arrays.sort(sarr);
        String sorted = String.join("", sarr);
        return !sorted.contains("AA");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // True
        System.out.println(s.checkRecord("PPALLP"));
        // False
        System.out.println(s.checkRecord("PPALLL"));
        // True
        System.out.println(s.checkRecord("LALL"));
    }

}
