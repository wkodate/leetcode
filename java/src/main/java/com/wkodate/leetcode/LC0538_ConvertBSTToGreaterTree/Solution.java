package com.wkodate.leetcode.LC0538_ConvertBSTToGreaterTree;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn00 = new TreeNode(5);
        tn00.left = new TreeNode(2);
        tn00.right = new TreeNode(13);
        System.out.println(s.convertBST(tn00).toString());
    }

}

