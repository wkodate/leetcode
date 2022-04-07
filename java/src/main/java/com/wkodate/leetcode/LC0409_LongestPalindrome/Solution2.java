package com.wkodate.leetcode.LC0409_LongestPalindrome;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int sum = 0;
        boolean hasOdd = false;
        for (Integer v : map.values()) {
            if (v % 2 == 0) {
                sum += v;
            } else {
                sum += v - 1;
                hasOdd = true;
            }
        }
        if (hasOdd) {
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 983
        System.out.println(s.longestPalindrome(
                "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
        // 7
        System.out.println(s.longestPalindrome("abccccdd"));
    }

}
