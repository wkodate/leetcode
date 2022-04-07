package com.wkodate.leetcode.LC0937_ReorderDataInLogFiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public String[] reorderLogFiles(String[] logs) {
        Map<String, List<String>> letters = new TreeMap<>();
        List<String> digits = new ArrayList<>();
        for (String log : logs) {
            String[] words = log.split(" ", 2);
            if (Character.isDigit(words[1].charAt(0))) {
                digits.add(log);
                continue;
            }
            String key = log.replaceFirst(words[0] + " ", "");
            List<String> list;
            if (letters.containsKey(key)) {
                list = letters.get(key);
            } else {
                list = new ArrayList<>();
            }
            list.add(log);
            letters.put(key, list);
        }

        int idx = 0;
        for (List<String> valueList : letters.values()) {
            Collections.sort(valueList);
            for (String value : valueList) {
                logs[idx++] = value;
            }
        }
        for (String digit : digits) {
            logs[idx++] = digit;
        }
        return logs;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"
        System.out.println(Arrays.toString(s.reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
        // []
        System.out.println(Arrays.toString(s.reorderLogFiles(new String[]{})));
        // ["a2 act car","g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
        System.out.println(Arrays.toString(s.reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"})));
    }

}
