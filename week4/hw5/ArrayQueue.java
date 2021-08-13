package com.example.answer.week4.hw5;

import com.example.answer.week4.Queue;

public class ArrayQueue implements Queue {

    private int[] queue;
    private int maxSize;
    private int rear;
    private int front;
    private int size;

    public int getSize() {
        return size;
    }

    public ArrayQueue() {
        final int DEFAULT_SIZE = 5;
        queue = new int[DEFAULT_SIZE];
        maxSize = DEFAULT_SIZE;
        size = 0;
        rear = -1;
        front = -1;
    }

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        size = 0;
        rear = -1;
        front = -1;
    }

    @Override
    public boolean add(int data) {
        if (size == maxSize) {
            throw new RuntimeException("queue is full");
        }
        rear = (rear + 1) % maxSize;
        queue[rear] = data;
        size++;
        return true;
    }

    @Override
    public int remove() {
        if(size == 0){
            throw new RuntimeException("queue is empty");
        }
        size--;
        front = (front + 1) % maxSize;
        int result = queue[front];
        queue[front] = 0;
        return result;
    }

    public void print() {
        for (int i : queue) {
            if(i != 0)
                System.out.println(i);
        }
    }
}
