package com.wkodate.leetcode.LC1379_FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(cloned);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val == target.val) {
                    return node;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        TreeNode original1 = TreeNode.fromArray(new Integer[]{7, 4, 3, null, null, 6, 19});
        TreeNode cloned1 = TreeNode.fromArray(new Integer[]{7, 4, 3, null, null, 6, 19});
        System.out.println(s.getTargetCopy(original1, cloned1, TreeNode.fromArray(new Integer[]{3, 6, 19})));
        // 7
        TreeNode original2 = TreeNode.fromArray(new Integer[]{7});
        TreeNode cloned2 = TreeNode.fromArray(new Integer[]{7});
        System.out.println(s.getTargetCopy(original2, cloned2, TreeNode.fromArray(new Integer[]{7})));
        // 4
        TreeNode original3 = TreeNode.fromArray(new Integer[]{8, null, 6, null, 5, null, 4, null, 3, null, 2, null, 1});
        TreeNode cloned3 = TreeNode.fromArray(new Integer[]{8, null, 6, null, 5, null, 4, null, 3, null, 2, null, 1});
        System.out.println(s.getTargetCopy(original3, cloned3, TreeNode.fromArray(new Integer[]{4, null, 3, null, 2, null, 1})));
        // 5
        TreeNode original4 = TreeNode.fromArray(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        TreeNode cloned4 = TreeNode.fromArray(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(s.getTargetCopy(original4, cloned4, TreeNode.fromArray(new Integer[]{5, 10})));
        // 2
        TreeNode original5 = TreeNode.fromArray(new Integer[]{1, 2, null, 3});
        TreeNode cloned5 = TreeNode.fromArray(new Integer[]{1, 2, null, 3});
        System.out.println(s.getTargetCopy(original5, cloned5, TreeNode.fromArray(new Integer[]{2, 3})));
    }

}
