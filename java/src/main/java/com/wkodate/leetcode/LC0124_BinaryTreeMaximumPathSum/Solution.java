package com.wkodate.leetcode.LC0124_BinaryTreeMaximumPathSum;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    private int max;

    private int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxPath(root.left), 0);
        int right = Math.max(maxPath(root.right), 0);
        int sum = root.val + left + right;
        max = Math.max(max, sum);
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPath(root);
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn = new TreeNode(1);
        tn.left = new TreeNode(2);
        tn.right = new TreeNode(3);
        System.out.println(s.maxPathSum(tn));
    }

}
