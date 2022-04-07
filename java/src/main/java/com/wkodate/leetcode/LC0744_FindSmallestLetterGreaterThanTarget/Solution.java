package com.wkodate.leetcode.LC0744_FindSmallestLetterGreaterThanTarget;

public class Solution {

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return letters[left % letters.length];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // c
        System.out.println(s.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        // f
        System.out.println(s.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        // f
        System.out.println(s.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        // j
        System.out.println(s.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
        // c
        System.out.println(s.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
        // c
        System.out.println(s.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));
    }

}
