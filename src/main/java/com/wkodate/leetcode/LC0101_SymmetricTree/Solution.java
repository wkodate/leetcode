package com.wkodate.leetcode.LC0101_SymmetricTree;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode tn00 = new TreeNode(1);
        TreeNode tn10 = new TreeNode(2);
        TreeNode tn11 = new TreeNode(2);
        TreeNode tn20 = new TreeNode(3);
        TreeNode tn21 = new TreeNode(4);
        TreeNode tn22 = new TreeNode(4);
        TreeNode tn23 = new TreeNode(3);
        tn10.left = tn20;
        tn10.right = tn21;
        tn11.left = tn22;
        tn11.right = tn23;
        tn00.left = tn10;
        tn00.right = tn11;
        System.out.println(solution.isSymmetric(tn00));
    }

}
