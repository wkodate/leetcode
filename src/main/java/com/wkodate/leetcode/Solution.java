package com.wkodate.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 929. Unique Email Addresses.
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] localDomain = email.split("@");
            String local = localDomain[0];
            String domain = localDomain[1];
            local = local.split("\\+")[0];
            local = local.replaceAll(".", "");
            set.add(local + domain);
        }
        return set.size();
    }

    /**
     * 387. First Unique Character in a String
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return idx;
            }
            idx++;
        }
        return -1;
    }

    /**
     * 349. Intersection of Two Arrays.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num1 : nums1) {
            set1.add(num1);
        }
        for (int num2 : nums2) {
            set2.add(num2);
        }
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int idx = 0;
        for (int s1 : set1) {
            result[idx++] = s1;
        }
        return result;
    }

    /**
     * 206. Reverse Linked List.
     */
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode tmp = current.next;
            // currentのnextにprevを入れて反転させたnodeをprevにする
            current.next = prev;
            prev = current;
            // currentに元のcurrent.nextを入れる
            current = tmp;
        }
        return prev;
    }

    /**
     * 141. Linked List Cycle.
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 111. Minimum Depth of Binary Tree.
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /**
     * 104. Maximum Depth of Binary Tree.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 83. Remove Duplicates from Sorted List.
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * 20. Valid Parentheses.
     */
    public boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }
        Deque<String> queue = new ArrayDeque<>();
        String[] sarr = s.split("");
        for (String str : sarr) {
            if ("(".equals(str) || "[".equals(str) || "{".equals(str)) {
                queue.push(str);
            } else {
                if (queue.size() == 0) {
                    return false;
                }
                String par = queue.pop();
                if ("(".equals(par) && !")".equals(str)
                        || "[".equals(par) && !"]".equals(str)
                        || "{".equals(par) && !"}".equals(str)
                ) {
                    return false;
                }
            }
        }
        return queue.size() == 0;
    }

    /**
     * 1. Two Sum.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar(""));
    }

}
