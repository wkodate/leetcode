package com.wkodate.leetcode.LC0225_ImplementStackUsingQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {

    private Deque<Integer> queue1;
    private Deque<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int ans = queue1.remove();
        while (!queue2.isEmpty()) {
            queue1.add(queue2.remove());
        }
        return ans;
    }

    /**
     * Get the top element.
     */
    public int top() {
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int ans = queue1.element();
        queue2.add(queue1.remove());
        while (!queue2.isEmpty()) {
            queue1.add(queue2.remove());
        }
        return ans;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        // 2
        System.out.println(stack.top());
        // 2
        System.out.println(stack.pop());
        // false
        System.out.println(stack.empty());
    }

}
