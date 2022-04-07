package com.wkodate.leetcode.LC0129_SumRootToLeafNumbers;

import java.util.ArrayList;
import java.util.List;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    private List<Integer> list;

    private void sumLeaf(TreeNode root, int sum) {
        sum = 10 * sum + root.val;
        if (root.left == null && root.right == null) {
            list.add(sum);
            return;
        }
        if (root.left != null) {
            sumLeaf(root.left, sum);
        }
        if (root.right != null) {
            sumLeaf(root.right, sum);
        }
    }

    public int sumNumbers(TreeNode root) {
        list = new ArrayList<>();
        if (root != null) {
            sumLeaf(root, 0);
        }
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            ans += list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 25
        TreeNode tn00 = new TreeNode(1);
        tn00.left = new TreeNode(2);
        tn00.right = new TreeNode(3);
        System.out.println(s.sumNumbers(tn00));
        // 1026
        TreeNode tn10_2 = new TreeNode(9);
        tn10_2.left = new TreeNode(5);
        tn10_2.right = new TreeNode(1);
        TreeNode tn00_2 = new TreeNode(4);
        tn00_2.left = tn10_2;
        tn00_2.right = new TreeNode(0);
        System.out.println(s.sumNumbers(tn00_2));
    }

}
