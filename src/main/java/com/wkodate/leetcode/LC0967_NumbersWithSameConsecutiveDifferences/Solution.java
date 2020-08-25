package com.wkodate.leetcode.LC0967_NumbersWithSameConsecutiveDifferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    Set<Integer> set;

    private void dfs(int digit, int[] arr, int k) {
        if (digit == arr.length) {
            int ans = 0;
            int d = (int) Math.pow(10, arr.length - 1);
            for (int i = 0; i < arr.length; i++) {
                ans += d * arr[i];
                d /= 10;
            }
            set.add(ans);
            return;
        }
        int add = arr[digit - 1] + k;
        if (add <= 9) {
            arr[digit] = add;
            dfs(digit + 1, arr, k);
        }
        int sub = arr[digit - 1] - k;
        if (sub >= 0) {
            arr[digit] = sub;
            dfs(digit + 1, arr, k);
        }
    }

    public int[] numsSameConsecDiff(int N, int K) {
        set = new HashSet<>();
        int start = 1;
        if (N == 1) {
            start = 0;
        }
        for (int i = start; i <= 9; i++) {
            int[] arr = new int[N];
            arr[0] = i;
            dfs(1, arr, K);
        }
        int[] ans = new int[set.size()];
        List<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,1,2,3,4,5,6,7,8,9]
        System.out.println(Arrays.toString(s.numsSameConsecDiff(1, 0)));
        System.out.println(Arrays.toString(s.numsSameConsecDiff(2, 0)));
        System.out.println(Arrays.toString(s.numsSameConsecDiff(1, 2)));
        // [181,292,707,818,929]
        System.out.println(Arrays.toString(s.numsSameConsecDiff(3, 7)));
        // [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
        System.out.println(Arrays.toString(s.numsSameConsecDiff(2, 1)));
    }

}
