package com.wkodate.leetcode.LC0658_FindKClosestElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr.length <= 0) {
            return new ArrayList<>();
        }
        int left = -1;
        int right = arr.length;
        int mid;
        while (right - left > 1) {
            mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int target = right;
        if (left >= 0
                && right <= arr.length - 1
                && arr[target] != x
                && (arr[right] - x > x - arr[left])) {
            target = left;
        }
        int count = 1;
        int l = target - 1;
        int r = target + 1;
        ans.add(arr[target]);
        while (count++ < k) {
            if (r >= arr.length
                    || (l >= 0 && (arr[r] - x) >= (x - arr[l]))) {
                ans.add(arr[l--]);
            } else {
                ans.add(arr[r++]);
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2,3,4]
        System.out.println(s.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3).toString());
        // [1,2,3,4]
        System.out.println(s.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1).toString());
        // [3,4,5]
        System.out.println(s.findClosestElements(new int[]{1, 2, 3, 4, 5}, 3, 5).toString());
        // []
        System.out.println(s.findClosestElements(new int[]{}, 0, 5).toString());
        // [1]
        System.out.println(s.findClosestElements(new int[]{1}, 1, 1).toString());
        // [3,3,4]
        System.out.println(s.findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5).toString());
        // [10]
        System.out.println(s.findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9).toString());
        // [5,5,6,6,7,7,8]
        System.out.println(s.findClosestElements(new int[]{1, 2, 5, 5, 6, 6, 7, 7, 8, 9}, 7, 7).toString());
    }

}
