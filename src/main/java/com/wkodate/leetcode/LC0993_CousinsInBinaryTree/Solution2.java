package com.wkodate.leetcode.LC0993_CousinsInBinaryTree;

import com.wkodate.leetcode.TreeNode;

public class Solution2 {

    private TreeNode xParent;
    private TreeNode yParent;
    private int xDepth = -1;
    private int yDepth = -2;

    public void dfs(TreeNode root, TreeNode parent, int x, int y, int depth) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            xParent = parent;
            xDepth = depth;
        } else if (y == root.val) {
            yParent = parent;
            yDepth = depth;
        } else {
            dfs(root.left, root, x, y, 1 + depth);
            dfs(root.right, root, x, y, 1 + depth);
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, x, y, 0);
        return xDepth == yDepth && xParent != yParent;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // false
        TreeNode tn00 = new TreeNode(1);
        TreeNode tn10 = new TreeNode(2);
        tn10.left = new TreeNode(4);
        tn00.left = tn10;
        tn00.right = new TreeNode(3);
        System.out.println(s.isCousins(tn00, 4, 3));

        // true
        TreeNode tn00_2 = new TreeNode(1);
        TreeNode tn10_2 = new TreeNode(2);
        TreeNode tn11_2 = new TreeNode(3);
        tn10_2.right = new TreeNode(5);
        tn11_2.right = new TreeNode(4);
        tn00_2.left = tn10_2;
        tn00_2.right = tn11_2;
        System.out.println(s.isCousins(tn00_2, 5, 4));

        //false
        TreeNode tn00_3 = new TreeNode(1);
        TreeNode tn10_3 = new TreeNode(2);
        tn10_3.right = new TreeNode(4);
        tn00_3.left = tn10_3;
        tn00_3.right = new TreeNode(3);
        System.out.println(s.isCousins(tn00_3, 2, 3));
    }

}
