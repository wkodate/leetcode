package com.wkodate.leetcode.LC0700_SearchInABinarySearchTree;

import java.util.ArrayDeque;
import java.util.Deque;

import com.wkodate.leetcode.TreeNode;

public class Solution2 {

    public TreeNode searchBST(TreeNode root, int val) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tn = queue.poll();
            if (tn.val == val) {
                return tn;
            }
            if (tn.left != null) {
                queue.add(tn.left);
            }
            if (tn.right != null) {
                queue.add(tn.right);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        TreeNode tn00 = new TreeNode(4);
        TreeNode tn10 = new TreeNode(2);
        tn10.left = new TreeNode(1);
        tn10.right = new TreeNode(3);
        tn00.left = tn10;
        tn00.right = new TreeNode(7);
        System.out.println(s.searchBST(tn00, 2));
    }

}
