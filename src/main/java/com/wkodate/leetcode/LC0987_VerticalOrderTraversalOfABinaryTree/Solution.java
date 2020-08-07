package com.wkodate.leetcode.LC0987_VerticalOrderTraversalOfABinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    private int min = 0;
    private int max = 0;
    private Map<Integer, PriorityQueue<int[]>> map;

    private void traverse(TreeNode root, int xVal, int level) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(xVal)) {
            min = Math.min(min, xVal);
            max = Math.max(max, xVal);
            map.put(xVal, new PriorityQueue<>((o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else { return o1[1] - o2[1]; }
            }));
        }
        map.get(xVal).add(new int[] { level, root.val });
        traverse(root.left, xVal - 1, level + 1);
        traverse(root.right, xVal + 1, level + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new HashMap<>();
        traverse(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>(max - min + 1);
        for (int i = min; i <= max; i++) {
            List<Integer> cur = new ArrayList<>();
            PriorityQueue<int[]> temp = map.get(i);
            while (!temp.isEmpty()) {
                cur.add(temp.poll()[1]);
            }
            res.add(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }

}
