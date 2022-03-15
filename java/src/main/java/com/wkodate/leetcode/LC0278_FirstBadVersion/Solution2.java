package com.wkodate.leetcode.LC0278_FirstBadVersion;

public class Solution2 extends VersionControl {

    @Override
    boolean isBadVersion(int version) {
        return 4 <= version;
    }

    public int firstBadVersion(int n) {
        int left = -1;
        int right = n;
        int mid;
        while (right - left > 1) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.firstBadVersion(4));
        // false
        System.out.println(s.isBadVersion(3));
        // true
        System.out.println(s.isBadVersion(5));
        // true
        System.out.println(s.isBadVersion(4));
    }
}
