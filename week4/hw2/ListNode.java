package com.example.answer.week4.hw2;

public class ListNode{

    int data;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int data){
        this.data = data;
        next = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public ListNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        if (head == null) {
            head = nodeToAdd;
            nodeToAdd.next = null;
            return nodeToAdd;
        }

        for (int i = 0; i < position - 1; i++) {
            head = head.next;
        }
        nodeToAdd.next = head.next;
        head.next = nodeToAdd;

        return nodeToAdd;
    }

}
