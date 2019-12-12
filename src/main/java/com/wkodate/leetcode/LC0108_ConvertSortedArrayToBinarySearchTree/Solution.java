package com.wkodate.leetcode.LC0108_ConvertSortedArrayToBinarySearchTree;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // [0,-3,5,-10,null,null,9]
        System.out.println(solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
        // null
        System.out.println(solution.sortedArrayToBST(new int[]{}));
        // [0]
        System.out.println(solution.sortedArrayToBST(new int[]{0}));
        // [3,1]
        System.out.println(solution.sortedArrayToBST(new int[]{1, 3}));
        // [3,1,5,0,2,4]
        System.out.println(solution.sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5}));
    }

}
