package com.wkodate.leetcode.LC0653_TwoSumIV;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (set.contains(k - node.val)) {
                return true;
            }
            set.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn00 = new TreeNode(5);
        TreeNode tn10 = new TreeNode(3);
        tn10.left = new TreeNode(2);
        tn10.right = new TreeNode(4);
        TreeNode tn11 = new TreeNode(6);
        tn11.right = new TreeNode(7);
        tn00.left = tn10;
        tn00.right = tn11;
        // true
        System.out.println(s.findTarget(tn00, 9));
        // false
        System.out.println(s.findTarget(tn00, 28));
    }

}
