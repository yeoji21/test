package com.example.answer.week4.hw2;

public class LinkedList implements HW2 {

    private ListNode head;
    private int size;

    public ListNode getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void print() {
        ListNode node = this.head;
        while (node != null) {
            System.out.println(node.toString());
            node = node.next;
        }
    }

    @Override
    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        if (positionRangeCheck(position)) {
            throw new IllegalArgumentException("잘 못된 position");
        }

        ++size;

        if (head == null) {
            this.head = nodeToAdd;
            return this.head;
        }

        if (position == 0) {
            nodeToAdd.next = this.head;
            this.head = nodeToAdd;
            return this.head;
        }

        ListNode node = head;
        for (int i = 0; i < position - 1; i++) {
            node = node.next;
        }

        nodeToAdd.next = node.next;
        node.next = nodeToAdd;
        return nodeToAdd;
    }

    private boolean positionRangeCheck(int position) {
        return position > this.size;
    }

    @Override
    public ListNode remove(ListNode head, int positionToRemove) {
        if (positionRangeCheck(positionToRemove)) {
            throw new IllegalArgumentException("잘 못된 position");
        }

        --size;

        if (positionToRemove == 0) {
            this.head = head.next;
            head.next = null;
            return head;
        }

        ListNode node = head;
        for (int i = 0; i < positionToRemove - 1; i++) {
            node = node.next;
        }

        ListNode deleteNode = node.next;
        node.next = deleteNode.next;
        deleteNode.next = null;

        return deleteNode;
    }

    @Override
    public boolean contains(ListNode head, ListNode nodeToCheck) {
        while (head != null) {
            if (head == nodeToCheck) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
