package com.wkodate.leetcode.LC0230_KthSmallestElementInABST;

import java.util.PriorityQueue;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    PriorityQueue<Integer> heap;

    private void findKthSmallest(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            findKthSmallest(root.left, k);
        }
        heap.add(root.val);
        if (heap.size() > k) {
            heap.poll();
        }
        if (root.right != null) {
            findKthSmallest(root.right, k);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        heap = new PriorityQueue<>((n1, n2) -> n2 - n1);
        findKthSmallest(root, k);
        return heap.poll();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn10 = new TreeNode(1);
        tn10.right = new TreeNode(2);
        TreeNode tn00 = new TreeNode(3);
        tn00.left = tn10;
        tn00.right = new TreeNode(4);
        System.out.println(s.kthSmallest(tn00, 1));

        TreeNode tn20_2 = new TreeNode(2);
        tn20_2.left = new TreeNode(1);
        TreeNode tn10_2 = new TreeNode(3);
        tn10_2.left = tn20_2;
        tn10_2.right = new TreeNode(4);
        TreeNode tn00_2 = new TreeNode(5);
        tn00_2.left = tn10_2;
        tn10.right = new TreeNode(6);
        System.out.println(s.kthSmallest(tn00_2, 3));
    }

}
