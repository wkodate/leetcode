package com.wkodate.leetcode.LC0036_ValidSudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> col = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (!col.contains(c)) {
                    col.add(c);
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c == '.') {
                    continue;
                }
                if (!row.contains(c)) {
                    row.add(c);
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> subbox = new HashSet<>();
                for (int k = 0; k <= 2; k++) {
                    for (int l = 0; l <= 2; l++) {
                        char c = board[i + k][j + l];
                        if (c == '.') {
                            continue;
                        }
                        if (!subbox.contains(c)) {
                            subbox.add(c);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        char[][] board1 = new char[9][9];
        board1[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        board1[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        board1[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        board1[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        board1[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        board1[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        board1[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        board1[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        board1[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        System.out.println(s.isValidSudoku(board1));
        // false
        char[][] board2 = new char[9][9];
        board2[0] = new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'};
        board2[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        board2[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        board2[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        board2[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        board2[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        board2[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        board2[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        board2[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        System.out.println(s.isValidSudoku(board2));

        // false
        char[][] board3 = new char[9][9];
        board3[0] = new char[]{'.', '.', '.', '.', '5', '.', '.', '1', '.'};
        board3[1] = new char[]{'.', '4', '.', '3', '.', '.', '.', '.', '.'};
        board3[2] = new char[]{'.', '.', '.', '.', '.', '3', '.', '.', '1'};
        board3[3] = new char[]{'8', '.', '.', '.', '.', '.', '.', '2', '.'};
        board3[4] = new char[]{'.', '.', '2', '.', '7', '.', '.', '.', '.'};
        board3[5] = new char[]{'.', '1', '5', '.', '.', '.', '.', '.', '.'};
        board3[6] = new char[]{'.', '.', '.', '.', '.', '2', '.', '.', '.'};
        board3[7] = new char[]{'.', '2', '.', '9', '.', '.', '.', '.', '.'};
        board3[8] = new char[]{'.', '.', '4', '.', '.', '.', '.', '.', '.'};
        System.out.println(s.isValidSudoku(board3));
    }

}
