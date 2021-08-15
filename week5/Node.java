package com.example.javastudy.week5;

// TODO: 2021/08/14
//  int 값을 가지고 있는 이진 트리를 나타내는 Node 라는 클래스를 정의하세요.
//  int value, Node left, right 를 가지고 있어야 합니다.

public class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
