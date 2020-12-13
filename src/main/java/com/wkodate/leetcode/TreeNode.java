package com.wkodate.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode fromArray(Integer[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(nums[0]);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(head);
        int i = 1;
        while (!queue.isEmpty() && i < nums.length) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();
                if (nums[i] != null) {
                    node.left = new TreeNode(nums[i]);
                    queue.add(node.left);
                }
                i++;
                if (i >= nums.length) {
                    break;
                }
                if (nums[i] != null) {
                    node.right = new TreeNode(nums[i]);
                    queue.add(node.right);
                }
                i++;
            }
        }
        return head;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(TreeNode.fromArray(new Integer[]{1}));
        System.out.println(TreeNode.fromArray(new Integer[]{1, 2, 3, 4, 5, null, 6}));
        System.out.println(TreeNode.fromArray(new Integer[]{1, 2, 2, null, 3, null, 3}));
        System.out.println(TreeNode.fromArray(new Integer[]{1, 2}));
        System.out.println(TreeNode.fromArray(new Integer[]{1, null, 2}));
    }
}
