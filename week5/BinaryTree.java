package com.example.javastudy.week5;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree implements Tree{

    private Node root;
    private int size;
    private Node last;

    public BinaryTree() {
        this.last = null;
        this.root = null;
        this.size = 0;
    }

    public Node getLast() {
        return last;
    }

    public Node getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void insert(int data) {

        Node newNode = new Node(data);
        this.last = newNode;
        Node head = this.root;

        if (this.size == 0) {
            this.root = newNode;
        }else{
            Queue<Node> q = new LinkedList<>();
            q.offer(head);
            while (!q.isEmpty()) {
                Node poll = q.poll();
                if (poll.left == null) {
                    poll.left = newNode;
                    break;
                }else{
                    q.offer(poll.left);
                }
                if (poll.right == null) {
                    poll.right = newNode;
                    break;
                }else{
                    q.offer(poll.right);
                }
            }
        }
        size++;
    }

    public void preorder(Node root) {
        if (root != null) {
            System.out.println(root.toString());
            preorder(root.left);
            preorder(root.right);
        }
    }

    public boolean contains(int data) {
        Node head = this.root;
        if (head == null) return false;

        Queue<Node> q = new LinkedList<>();
        q.offer(head);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.value == data)
                return true;
            if (temp.left != null)
                q.offer(temp.left);
            if (temp.right != null)
                q.offer(temp.right);
        }
        return false;
    }

    private Node deleteLast() {
        Node head = this.root;
        Node last = head;
        Node currentLast = this.last;
        if (size == 1) root = null;
        else{
            Queue<Node> q = new LinkedList<>();
            q.offer(head);
            while (!q.isEmpty()) {
                Node temp = q.poll();

                if (temp.left!= null && temp.left == this.last) {
                    temp.left = null;
                    break;
                }else{
                    q.offer(temp.left);
                }
                if (temp.right!= null && temp.right == this.last) {
                    temp.right = null;
                    break;
                }else{
                    q.offer(temp.right);
                }
            }

            q.offer(head);
            while (!q.isEmpty()) {
                Node temp = q.poll();
                last = temp;
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
            }
            this.last = last;
        }

        size--;
        return currentLast;
    }


    @Override
    public int delete(int data) {
        if(!contains(data)){
            throw new RuntimeException("data not found");
        }
        Node head = this.root;
        Node lastNode = deleteLast();
        Queue<Node> q = new LinkedList<>();
        q.offer(head);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.value == data) {
                temp.value = lastNode.value;
                break;
            }
            if (temp.left != null) {
                q.offer(temp.left);
            }

            if (temp.right != null) {
                q.offer(temp.right);
            }
        }
        return data;
    }


    @Override
    public void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.println(temp.toString());
            if (temp.left != null) {
                q.offer(temp.left);
            }
            if (temp.right != null) {
                q.offer(temp.right);
            }
        }
    }

    @Override
    public void dfs(Node node) {
        if(node.left == null && node.right==null)
            System.out.println(node.toString());
        else{
            if (node.left != null) {
                dfs(node.left);
            }
            System.out.println(node.toString());
            if (node.right != null) {
                dfs(node.right);
            }
        }
    }
}
