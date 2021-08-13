package com.example.answer.week4.hw5;

import com.example.answer.week4.Queue;
import com.example.answer.week4.hw2.ListNode;

public class LinkedQueue implements Queue {

    private int size;
    private ListNode rear;
    private ListNode front;

    public int getSize() {
        return size;
    }

    public LinkedQueue() {
        size = 0;
        rear = null;
        front = null;
    }

    @Override
    public boolean add(int data) {
        ListNode node = new ListNode(data);
        if (front == null) {
            front = node;
        } else{
            rear.add(rear, node, 1);
        }
        size++;
        this.rear = node;
        return true;
    }

    @Override
    public int remove() {
        if (size == 0) {
            throw new RuntimeException("queue is empty");
        }
        ListNode node = front.getNext();
        int deleteData = front.getData();
        this.front = node;
        size--;
        return deleteData;
    }

    public void print() {
        ListNode node = front;
        while (node != null
        ) {
            System.out.println(node.toString());
            node = node.getNext();
        }
    }
}
