package com.wkodate.leetcode.LC0155_MinStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack2 {

    private Deque<Integer> stack;
    private int min = Integer.MAX_VALUE;

    public MinStack2() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-5);
        // -3
        System.out.println(minStack.getMin());
        minStack.pop();
        // 0
        System.out.println(minStack.top());
        // -2
        System.out.println(minStack.getMin());
    }

}
