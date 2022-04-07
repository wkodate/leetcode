package com.wkodate.leetcode.LC0155_MinStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    Deque<Integer> stack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
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
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        //  Returns -3.
        System.out.println(minStack.getMin());
        minStack.pop();
        //  Returns 0.
        System.out.println(minStack.top());
        //  Returns -2.
        System.out.println(minStack.getMin());
    }

}
