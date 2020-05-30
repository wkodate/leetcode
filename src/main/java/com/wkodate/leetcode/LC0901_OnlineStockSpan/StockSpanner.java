package com.wkodate.leetcode.LC0901_OnlineStockSpan;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {

    Deque<Integer> stack;
    Deque<Integer> weights;

    public StockSpanner() {
        stack = new ArrayDeque<>();
        weights = new ArrayDeque<>();
    }

    public int next(int price) {
        Deque<Integer> tmp = new ArrayDeque<>();
        int w = 1;
        while (!stack.isEmpty() && stack.peek() <= price) {
            stack.pop();
            w += weights.pop();
        }
        stack.push(price);
        weights.push(w);
        return w;
    }

    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();
        // 1
        System.out.println(s.next(100));
        // 1
        System.out.println(s.next(80));
        // 1
        System.out.println(s.next(60));
        // 2
        System.out.println(s.next(70));
        // 1
        System.out.println(s.next(60));
        // 4
        System.out.println(s.next(75));
        // 6
        System.out.println(s.next(85));

        StockSpanner s2 = new StockSpanner();
        // 1
        System.out.println(s2.next(31));
        // 2
        System.out.println(s2.next(41));
        // 3
        System.out.println(s2.next(48));
        // 4
        System.out.println(s2.next(59));
        // 5
        System.out.println(s2.next(79));

        StockSpanner s3 = new StockSpanner();
        // 1
        System.out.println(s3.next(29));
        // 2
        System.out.println(s3.next(91));
        // 1
        System.out.println(s3.next(62));
        // 2
        System.out.println(s3.next(76));
        // 1
        System.out.println(s3.next(51));

        StockSpanner s4 = new StockSpanner();
        // 1
        System.out.println(s4.next(28));
        // 1
        System.out.println(s4.next(14));
        // 3
        System.out.println(s4.next(28));
        // 4
        System.out.println(s4.next(35));
        // 5
        System.out.println(s4.next(46));
        // 6
        System.out.println(s4.next(53));
        // 7
        System.out.println(s4.next(66));
        // 8
        System.out.println(s4.next(80));
        // 9
        System.out.println(s4.next(87));
        // 10
        System.out.println(s4.next(88));

        StockSpanner s5 = new StockSpanner();
        long start = System.currentTimeMillis();
        System.out.println("start");
        for (int i = 0; i < 10000; i++) {
            System.out.println(s5.next(1));
        }
        long end = System.currentTimeMillis();
        System.out.println("finished:" + (end - start));

    }

}
