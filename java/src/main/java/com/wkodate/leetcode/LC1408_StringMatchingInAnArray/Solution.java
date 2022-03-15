package com.wkodate.leetcode.LC1408_StringMatchingInAnArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                if (words[j].contains(word)) {
                    ans.add(word);
                    break;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // ["as","hero"]
        System.out.println(s.stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
        // ["et","code"]
        System.out.println(s.stringMatching(new String[]{"leetcode", "et", "code"}));
        // []
        System.out.println(s.stringMatching(new String[]{"blue", "green", "bu"}));
    }

}
