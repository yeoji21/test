package com.example.answer.week4.hw3;

import com.example.answer.week4.Stack;

public class ArrayStack implements Stack {
    private int[] stack;
    private int maxSize;
    private int size;

    public ArrayStack() {
        final int DEFAULT_SIZE = 10;
        stack = new int[DEFAULT_SIZE];
        maxSize = DEFAULT_SIZE;
        size = 0;
    }

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
        size = 0;
    }

    public void print() {
        for (int i : stack) {
            if(i != 0)
                System.out.println(i);
        }
    }

    public int sum() {
        int total = 0;
        for (int i : stack) {
            if(i != 0)
                total += i;
        }
        return total;
    }

    @Override
    public void push(int data) {
        if (size >= maxSize) {
            throw new ArrayIndexOutOfBoundsException("스택이 꽉 찼습니다");
        }
        stack[size++] = data;
    }

    @Override
    public int pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("스택이 비었습니다");
        }
        return stack[--size];
    }
}
