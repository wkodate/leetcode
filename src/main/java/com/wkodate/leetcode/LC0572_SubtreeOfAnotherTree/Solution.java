package com.wkodate.leetcode.LC0572_SubtreeOfAnotherTree;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    public boolean equals(TreeNode x, TreeNode y) {
        if (x == null && y == null) {
            return true;
        }
        if (x == null || y == null) {
            return false;
        }
        return x.val == y.val && equals(x.left, y.left) && equals(x.right, y.right);
    }

    public boolean traverse(TreeNode s, TreeNode t) {
        return s != null && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode s20 = new TreeNode(1);
        TreeNode s21 = new TreeNode(2);
        TreeNode s10 = new TreeNode(4);
        s10.left = s20;
        s10.right = s21;
        TreeNode s11 = new TreeNode(5);
        TreeNode s0 = new TreeNode(3);
        s0.left = s10;
        s0.right = s11;
        TreeNode t10 = new TreeNode(1);
        TreeNode t11 = new TreeNode(2);
        TreeNode t0 = new TreeNode(4);
        t0.left = t10;
        t0.right = t11;
        System.out.println(solution.isSubtree(s0, t0));
    }

}
