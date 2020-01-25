package com.wkodate.leetcode.LC0783_MinimumDistanceBetweenBSTNodes;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    Integer res = Integer.MAX_VALUE;
    Integer pre = null;

    public int minDiffInBST(TreeNode root) {
        if (root.left != null) {
            minDiffInBST(root.left);
        }
        if (pre != null) {
            res = Math.min(res, root.val - pre);
        }
        pre = root.val;
        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn00 = new TreeNode(4);
        TreeNode tn10 = new TreeNode(2);
        tn10.left = new TreeNode(1);
        tn10.right = new TreeNode(3);
        tn00.left = tn10;
        tn00.right = new TreeNode(6);

        System.out.println(s.minDiffInBST(tn00));
    }

}
