package com.wkodate.leetcode.LC0406_QueueReconstructionByHeight;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(people, Comparator.comparingInt(a -> a[0]));
        int[][] ans = new int[people.length][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i][0] = -1;
        }
        int j = -1;
        int k = -1;
        for (int i = 0; i < people.length; i++) {
            int[] person = people[i];
            if (i != 0 && person[0] != people[i - 1][0]) {
                j = -1;
                k = -1;
            }
            while (j < ans.length - 1) {
                j++;
                if (ans[j][0] != -1) {
                    continue;
                }
                k++;
                if (k == person[1]) {
                    ans[j] = person;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[3,0],[6,0],[7,0],[5,2],[3,4],[5,3],[6,2],[2,7],[9,0],[1,9]]
        int[][] people = {
                { 9, 0 }, { 7, 0 }, { 1, 9 }, { 3, 0 }, { 2, 7 }, { 5, 3 }, { 6, 0 }, { 3, 4 }, { 6, 2 },
                { 5, 2 }
        };
        System.out.println(Arrays.deepToString(s.reconstructQueue(people)));
        // [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
        System.out.println(Arrays.deepToString(s.reconstructQueue(
                new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } })));
    }

}
