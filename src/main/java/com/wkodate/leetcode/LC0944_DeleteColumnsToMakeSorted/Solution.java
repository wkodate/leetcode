package com.wkodate.leetcode.LC0944_DeleteColumnsToMakeSorted;

public class Solution {

    public int minDeletionSize(String[] A) {
        int nondLen = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    nondLen++;
                    break;
                }
            }
        }
        return nondLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        // 0
        System.out.println(s.minDeletionSize(new String[]{"a", "b"}));
        // 3
        System.out.println(s.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
    }

}
