package com.wkodate.leetcode.LC0100_SameTree;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode p0 = new TreeNode(1);
        TreeNode q0 = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode q1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        TreeNode q2 = new TreeNode(3);
        p0.left = p1;
        q0.left = q1;
        p0.right = p2;
        q0.right = q2;
        System.out.println(s.isSameTree(p0, q0));
    }

}
