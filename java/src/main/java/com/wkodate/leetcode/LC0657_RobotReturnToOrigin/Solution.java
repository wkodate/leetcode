package com.wkodate.leetcode.LC0657_RobotReturnToOrigin;

public class Solution {

    public boolean judgeCircle(String moves) {
        int posX = 0;
        int posY = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'R') {
                posX++;
            } else if (c == 'L') {
                posX--;

            } else if (c == 'U') {
                posY++;
            } else {
                posY--;
            }
        }
        return posX == 0 && posY == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.judgeCircle("UD"));
        // false
        System.out.println(s.judgeCircle("LL"));
    }

}
