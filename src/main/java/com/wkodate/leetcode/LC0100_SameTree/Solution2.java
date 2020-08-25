package com.wkodate.leetcode.LC0100_SameTree;

import java.util.ArrayDeque;
import java.util.Deque;

import com.wkodate.leetcode.TreeNode;

public class Solution2 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        Deque<TreeNode> queue1 = new ArrayDeque<>();
        Deque<TreeNode> queue2 = new ArrayDeque<>();
        queue1.add(p);
        queue2.add(q);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (queue1.isEmpty() || queue2.isEmpty()) {
                return false;
            }
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                TreeNode p1 = queue1.poll();
                TreeNode q1 = queue2.poll();
                if (p1.val != q1.val) {
                    return false;
                }
                if (p1.left != null) {
                    if (q1.left == null) {
                        return false;
                    }
                    queue1.add(p1.left);
                    queue2.add(q1.left);
                } else {
                    if (q1.left != null) {
                        return false;
                    }
                }
                if (p1.right != null) {
                    if (q1.right == null) {
                        return false;
                    }
                    queue1.add(p1.right);
                    queue2.add(q1.right);
                } else {
                    if (q1.right != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();

        // true
        TreeNode p0 = new TreeNode(1);
        TreeNode q0 = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode q1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        TreeNode q2 = new TreeNode(3);
        p0.left = p1;
        q0.left = q1;
        p0.right = p2;
        q0.right = q2;
        System.out.println(s.isSameTree(p0, q0));

        // false
        TreeNode p0_2 = new TreeNode(1);
        TreeNode q0_2 = new TreeNode(1);
        TreeNode q1_2 = new TreeNode(2);
        TreeNode p2_2 = new TreeNode(3);
        TreeNode q2_2 = new TreeNode(3);
        p0_2.right = p2_2;
        q0_2.left = q1_2;
        q0_2.right = q2_2;
        System.out.println(s.isSameTree(p0_2, q0_2));
    }

}
