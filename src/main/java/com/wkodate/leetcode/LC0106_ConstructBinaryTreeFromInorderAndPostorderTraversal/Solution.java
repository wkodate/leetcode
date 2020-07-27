package com.wkodate.leetcode.LC0106_ConstructBinaryTreeFromInorderAndPostorderTraversal;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    private TreeNode buildTree(int[] inorder, int ioStart, int ioEnd, int[] postorder, int poStart, int poEnd) {
        if (ioStart > ioEnd || poStart > poEnd) {
            return null;
        }
        int rval = postorder[poEnd];
        TreeNode root = new TreeNode(rval);
        int i = ioStart;
        while (inorder[i] != rval) {
            i++;
        }
        root.right = buildTree(inorder, i + 1, ioEnd, postorder, poStart + i - ioStart, poEnd - 1);
        root.left = buildTree(inorder, ioStart, i - 1, postorder, poStart, poStart + i - (ioStart + 1));
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 }));
    }

}
