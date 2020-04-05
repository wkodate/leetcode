package com.wkodate.leetcode.LC0283_MoveZeroes;

import java.util.Arrays;

public class Solution2 {

    public void moveZeroes(int[] nums) {
        int zero = 0;
        int i;
        while (true) {
            while (zero <= nums.length - 1 && nums[zero] != 0) {
                zero++;
            }
            i = zero;
            while (i <= nums.length - 1 && nums[i] == 0) {
                i++;
            }
            if (zero > nums.length - 1 || i > nums.length - 1) {
                break;
            }
            int tmp = nums[zero];
            nums[zero] = nums[i];
            nums[i] = tmp;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 1,3,12,0,0
        s.moveZeroes(new int[]{0, 1, 0, 3, 12});
        // 1,0
        s.moveZeroes(new int[]{1, 0});
        // 1,0
        s.moveZeroes(new int[]{0, 1});
        // 4,2,4,3,5,1,0,0,0,0
        s.moveZeroes(new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0});
    }

}
