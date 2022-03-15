package com.wkodate.leetcode.LC0221_MaximalSquare;

public class Solution {

    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                boolean square = true;
                int k = 1;
                ans = Math.max(ans, 1);
                while (square && i + k < matrix.length && j + k < matrix[0].length) {
                    for (int l = i; l <= i + k; l++) {
                        for (int m = j; m <= j + k; m++) {
                            if (matrix[l][m] == '0') {
                                square = false;
                                break;
                            }
                        }
                        if (!square) {
                            break;
                        }
                    }
                    if (square) {
                        ans = Math.max(ans, (int) Math.pow(k + 1, 2));
                    }
                    k++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.maximalSquare(new char[][] { { '1', '1' }, { '1', '1' } }));
        // 1
        System.out.println(s.maximalSquare(new char[][] { { '1' } }));
        // 0
        System.out.println(s.maximalSquare(new char[][] { { '0' } }));
        // 4
        char[][] matrix = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '1' },
                };
        System.out.println(s.maximalSquare(matrix));
    }

}
