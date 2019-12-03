package com.wkodate.leetcode.LC0027_RemoveElement;

public class Solution {

    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int slow = 0;
        for (int fast = 0; fast < length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // expected 2, [2,2]
        System.out.println(solution.removeElement(new int[]{3, 2, 2, 3}, 3));
        // expected 5, [0,1,4,0,3]
        System.out.println(solution.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

}
