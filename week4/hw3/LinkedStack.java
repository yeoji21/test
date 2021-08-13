package com.example.answer.week4.hw3;

import com.example.answer.week4.Stack;
import com.example.answer.week4.hw2.ListNode;

public class LinkedStack implements Stack {

    private ListNode head;
    private int size;

    public int getSize() {
        return size;
    }

    public LinkedStack() {
        head = null;
        size = 0;
    }

    @Override
    public void push(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        else{
            head.add(head, node, size++);
        }
    }

    @Override
    public int pop() {
        if (head == null) {
            throw new RuntimeException("스택이 비었습니다.");
        }

        ListNode node = this.head;
        for (int i = 1; i < this.size-1; i++) {
            node = node.getNext();
        }
        ListNode deleteNode = node.getNext();
        size--;

        if (deleteNode == null) {
            head = null;
            return node.getData();
        }

        node.setNext(null);
        return deleteNode.getData();
    }

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.getNext();
        }
    }

    public int sum() {
        ListNode temp = head;
        int sum = 0;
        while (temp != null) {
            sum += temp.getData();
            temp = temp.getNext();
        }
        return sum;
    }
}
