package com.wkodate.leetcode.LC0707_DesignLinkedList;

public class MyLinkedList {

    public static class Node {
        public int val;

        public Node next;

        public Node(int x) {
            val = x;
            next = null;
        }
    }

    private Node head;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list.
     * If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node h = new Node(val);
        h.next = head;
        head = h;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(val);
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list,
     * the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        size++;
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node current = head;
        if (index == 0) {
            Node tmp = head;
            head = new Node(val);
            head.next = tmp;
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        Node current = head;
        Node prev = head;
        size--;
        if (index == 0) {
            head = current.next;
            return;
        }
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList1 = new MyLinkedList();
        System.out.println("LinkedList1");
        linkedList1.addAtHead(1);
        linkedList1.addAtTail(3);
        linkedList1.addAtIndex(1, 2);
        // 2
        System.out.println(linkedList1.get(1));
        linkedList1.deleteAtIndex(1);
        // 3
        System.out.println(linkedList1.get(1));

        System.out.println("LinkedList2");
        MyLinkedList linkedList2 = new MyLinkedList();
        linkedList2.addAtHead(1);
        linkedList2.addAtTail(3);
        linkedList2.addAtIndex(1, 2);
        // 2
        System.out.println(linkedList2.get(1));
        linkedList2.deleteAtIndex(0);
        // 2
        System.out.println(linkedList2.get(0));

        System.out.println("LinkedList3");
        MyLinkedList linkedList3 = new MyLinkedList();
        linkedList3.addAtIndex(0, 10);
        linkedList3.addAtIndex(0, 20);
        linkedList3.addAtIndex(1, 30);
        // 20
        System.out.println(linkedList3.get(0));

        System.out.println("LinkedList4");
        MyLinkedList linkedList4 = new MyLinkedList();
        linkedList4.addAtHead(2);
        linkedList4.deleteAtIndex(1);
        linkedList4.addAtHead(2);
        linkedList4.addAtHead(7);
        linkedList4.addAtHead(3);
        linkedList4.addAtHead(2);
        linkedList4.addAtHead(5);
        linkedList4.addAtTail(5);
        // 2
        System.out.println(linkedList4.get(5));
        linkedList4.deleteAtIndex(6);
        linkedList4.deleteAtIndex(4);
    }

}
