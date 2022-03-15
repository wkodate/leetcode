package com.wkodate.leetcode.LC0102_BinaryTreeLevelOrderTraversal;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn11 = new TreeNode(20);
        tn11.left = new TreeNode(15);
        tn11.right = new TreeNode(7);
        TreeNode tn00 = new TreeNode(3);
        tn00.left = new TreeNode(9);
        tn00.right = tn11;
        System.out.println(s.levelOrder(tn00));
    }

}
