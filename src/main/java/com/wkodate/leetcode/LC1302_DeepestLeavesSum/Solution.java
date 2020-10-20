package com.wkodate.leetcode.LC1302_DeepestLeavesSum;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode tn20 = new TreeNode(4);
        tn20.left = new TreeNode(7);
        TreeNode tn10 = new TreeNode(2);
        tn10.left = tn20;
        tn10.right = new TreeNode(5);
        TreeNode tn11 = new TreeNode(3);
        TreeNode tn23 = new TreeNode(6);
        tn23.right = new TreeNode(8);
        tn11.right = tn23;
        TreeNode tn00 = new TreeNode(1);
        tn00.left = tn10;
        tn00.right = tn11;
        // 15
        System.out.println(s.deepestLeavesSum(tn00));
    }

}
