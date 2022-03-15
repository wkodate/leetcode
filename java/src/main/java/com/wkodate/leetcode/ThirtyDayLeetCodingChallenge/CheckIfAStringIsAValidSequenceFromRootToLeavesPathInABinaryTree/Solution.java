package com.wkodate.leetcode.ThirtyDayLeetCodingChallenge.CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    private boolean dfs(TreeNode node, int[] arr, int depth) {
        if (node == null || depth >= arr.length || arr[depth] != node.val) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return 1 + depth == arr.length;
        }
        return dfs(node.left, arr, 1 + depth) || dfs(node.right, arr, 1 + depth);
    }

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn00 = new TreeNode(0);
        TreeNode tn10 = new TreeNode(1);
        TreeNode tn20 = new TreeNode(0);
        tn20.right = new TreeNode(1);
        tn10.left = tn20;
        TreeNode tn21 = new TreeNode(1);
        tn21.left = new TreeNode(0);
        tn21.right = new TreeNode(0);
        tn10.right = tn21;
        TreeNode tn11 = new TreeNode(0);
        tn11.left = new TreeNode(0);
        tn00.left = tn10;
        tn00.right = tn11;
        System.out.println(s.isValidSequence(tn00, new int[] { 0, 1, 0, 1 }));
    }
}
