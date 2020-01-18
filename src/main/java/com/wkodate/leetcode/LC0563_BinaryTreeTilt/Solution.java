package com.wkodate.leetcode.LC0563_BinaryTreeTilt;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    int tilt = 0;

    public int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }

    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn00 = new TreeNode(1);
        tn00.left = new TreeNode(2);
        tn00.right = new TreeNode(3);
        System.out.println(s.findTilt(tn00));
    }

}
