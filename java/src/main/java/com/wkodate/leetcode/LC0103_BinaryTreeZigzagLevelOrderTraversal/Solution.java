package com.wkodate.leetcode.LC0103_BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        queue.add(root);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            cnt++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (cnt % 2 == 0) {
                Collections.reverse(list);
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[3],[20,9],[15,7]]
        TreeNode tn11 = new TreeNode(20);
        tn11.left = new TreeNode(15);
        tn11.right = new TreeNode(7);
        TreeNode tn00 = new TreeNode(3);
        tn00.left = new TreeNode(9);
        tn00.right = tn11;
        System.out.println(s.zigzagLevelOrder(tn00));
    }

}
