package com.wkodate.leetcode.LC0232_ImplementQueueUsingStacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;
    int front;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stack1.isEmpty()) {
            front = x;
        }
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (stack1.size() >= 1) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return front;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        // 1
        System.out.println(queue.peek());
        // 1
        System.out.println(queue.pop());
        // false
        System.out.println(queue.empty());
    }

}
