package com.wkodate.leetcode.LC0107_BinaryTreeLevelOrderTraversalII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import com.wkodate.leetcode.TreeNode;

public class Solution2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
                TreeNode node = queue.poll();
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
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        TreeNode p0 = new TreeNode(3);
        TreeNode p10 = new TreeNode(9);
        TreeNode p11 = new TreeNode(20);
        TreeNode p22 = new TreeNode(15);
        TreeNode p23 = new TreeNode(7);
        p11.left = p22;
        p11.right = p23;
        p0.left = p10;
        p0.right = p11;
        // [[15,7],[9,20],[3]]
        System.out.println(s.levelOrderBottom(p0));
        System.out.println(s.levelOrderBottom(null));
    }

}
