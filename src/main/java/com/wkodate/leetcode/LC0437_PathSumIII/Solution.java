package com.wkodate.leetcode.LC0437_PathSumIII;

import java.util.ArrayDeque;
import java.util.Deque;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    private int ans;

    private void dfs(TreeNode root, int s, int sum) {
        if (s == sum) {
            ans++;
        }
        if (root.left != null) {
            dfs(root.left, s + root.left.val, sum);
        }
        if (root.right != null) {
            dfs(root.right, s + root.right.val, sum);
        }
    }

    private void bfsroot(TreeNode root, int sum) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                dfs(node, node.val, sum);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public int pathSum(TreeNode root, int sum) {
        ans = 0;
        if (root == null) {
            return ans;
        }
        bfsroot(root, sum);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        TreeNode tn20 = new TreeNode(3);
        tn20.left = new TreeNode(3);
        tn20.right = new TreeNode(-2);
        TreeNode tn21 = new TreeNode(2);
        tn21.right = new TreeNode(1);
        TreeNode tn10 = new TreeNode(5);
        tn10.left = tn20;
        tn10.right = tn21;
        TreeNode tn11 = new TreeNode(-3);
        tn11.right = new TreeNode(11);
        TreeNode tn00 = new TreeNode(10);
        tn00.left = tn10;
        tn00.right = tn11;
        System.out.println(s.pathSum(tn00, 8));
        // 0
        System.out.println(s.pathSum(null, 1));
        // 1
        System.out.println(s.pathSum(new TreeNode(1), 1));
    }

}
