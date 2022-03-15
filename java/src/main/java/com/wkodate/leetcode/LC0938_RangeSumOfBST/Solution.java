package com.wkodate.leetcode.LC0938_RangeSumOfBST;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val >= L && node.val <= R) {
                sum += node.val;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn00 = new TreeNode(10);
        TreeNode tn10 = new TreeNode(5);
        TreeNode tn11 = new TreeNode(15);
        TreeNode tn20 = new TreeNode(3);
        TreeNode tn21 = new TreeNode(7);
        TreeNode tn23 = new TreeNode(18);
        tn10.left = tn20;
        tn10.right = tn21;
        tn11.right = tn23;
        tn00.left = tn10;
        tn00.right = tn11;
        System.out.println(s.rangeSumBST(tn00, 7, 15));
        TreeNode tn22 = new TreeNode(13);
        tn11.left = tn22;
        TreeNode tn30 = new TreeNode(1);
        tn20.left = tn30;
        TreeNode tn32 = new TreeNode(6);
        tn21.left = tn32;
        System.out.println(s.rangeSumBST(tn00, 6, 10));
    }

}
