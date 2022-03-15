package com.wkodate.leetcode.LC0278_FirstBadVersion;

public class Solution extends VersionControl {

    /**
     * dummy method.
     */
    boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (right - left >= 1) {
            // int mid = (left + right) / 2; だとoverflowする
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

}
