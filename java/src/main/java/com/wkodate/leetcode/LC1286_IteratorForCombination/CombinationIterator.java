package com.wkodate.leetcode.LC1286_IteratorForCombination;

import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {

    private List<String> list;
    private int idx;

    public CombinationIterator(String characters, int combinationLength) {
        list = new ArrayList<>();
        idx = 0;
        permutate(characters.toCharArray(), "", combinationLength);
    }

    private void permutate(char[] c, String word, int len) {
        if (word.length() == len) {
            list.add(word);
            return;
        }
        for (int i = 0; i < c.length; i++) {
            char[] nodup = new char[c.length - 1];
            int k = 0;
            for (int j = i + 1; j < c.length; j++) {
                nodup[k++] = c[j];
            }
            if (c[i] != 0) {
                permutate(nodup, word + c[i], len);
            }
        }
    }

    public String next() {
        return list.get(idx++);
    }

    public boolean hasNext() {
        return idx < list.size();
    }

    public static void main(String[] args) {
        CombinationIterator iterator = new CombinationIterator("abc", 2);
        // ab
        System.out.println(iterator.next());
        // true
        System.out.println(iterator.hasNext());
        // ac
        System.out.println(iterator.next());
        // true
        System.out.println(iterator.hasNext());
        // bc
        System.out.println(iterator.next());
        // false
        System.out.println(iterator.hasNext());
    }

}
