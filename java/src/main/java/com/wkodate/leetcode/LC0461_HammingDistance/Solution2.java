package com.wkodate.leetcode.LC0461_HammingDistance;

public class Solution2 {

    public int hammingDistance(int x, int y) {
        String xs = Integer.toBinaryString(x);
        String ys = Integer.toBinaryString(y);
        int len = Math.max(xs.length(), ys.length());
        xs = String.format("%" + len + "s", xs).replace(' ', '0');
        ys = String.format("%" + len + "s", ys).replace(' ', '0');
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (xs.charAt(xs.length() - 1 - i) != ys.charAt(ys.length() - 1 - i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 2
        System.out.println(s.hammingDistance(1, 4));
        System.out.println(s.hammingDistance(1577962638, 1727613287));
    }

}
