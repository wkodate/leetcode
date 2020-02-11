package com.wkodate.leetcode.LC0622_DesignCircularQueue;

public class MyCircularQueue {

    private int[] queue;
    private int head = -1;
    private int tail = -1;
    private int size;

    /**
     * Initialize your data structure here.
     * Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.queue = new int[1000];
        this.size = k;
    }

    /**
     * Insert an element into the circular queue.
     * Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
            tail = 0;
        } else {
            if (tail >= size - 1) {
                tail = 0;
            } else {
                tail++;
            }
        }
        queue[tail] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue.
     * Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
        } else if (head >= size - 1) {
            head = 0;
        } else {
            head++;
        }
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return head == -1 && tail == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return head - tail == 1 || (head == 0 && tail == size - 1);
    }

    public static void main(String[] args) {
        System.out.println("*MyCircularQueue1");
        MyCircularQueue circularQueue1 = new MyCircularQueue(3); // set the size to be 3
        // true
        System.out.println(circularQueue1.enQueue(1));
        // true
        System.out.println(circularQueue1.enQueue(2));
        // true
        System.out.println(circularQueue1.enQueue(3));
        // false
        System.out.println(circularQueue1.enQueue(4));
        // 3
        System.out.println(circularQueue1.Rear());
        // true
        System.out.println(circularQueue1.isFull());
        // true
        System.out.println(circularQueue1.deQueue());
        // true
        System.out.println(circularQueue1.enQueue(4));
        // 4
        System.out.println(circularQueue1.Rear());

        System.out.println("*MyCircularQueue2");
        MyCircularQueue circularQueue2 = new MyCircularQueue(6); // set the size to be 3
        // true
        System.out.println(circularQueue2.enQueue(6));
        // 6
        System.out.println(circularQueue2.Rear());
        // 6
        System.out.println(circularQueue2.Rear());
        // true
        System.out.println(circularQueue2.deQueue());
        // true
        System.out.println(circularQueue2.enQueue(5));
        // 5
        System.out.println(circularQueue2.Rear());
        // true
        System.out.println(circularQueue2.deQueue());
        // -1
        System.out.println(circularQueue2.Front());
        // false
        System.out.println(circularQueue2.deQueue());
        // false
        System.out.println(circularQueue2.deQueue());
        // false
        System.out.println(circularQueue2.deQueue());
    }

}
