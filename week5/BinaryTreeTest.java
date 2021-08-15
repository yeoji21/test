package com.example.javastudy.week5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BinaryTreeTest {

    BinaryTree bt = new BinaryTree();

    @Test
    @Order(1)
    void insertNode() {
        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(5);
        assertEquals(bt.getSize(),5);
    }

    @Test
    @Order(2)
    void contains() {
        assertTrue(bt.contains(2));
        assertFalse(bt.contains(21));
    }

    @Test
    @Order(3)
    void bfs() {
        System.out.println("-----bfs-----");
        bt.bfs(bt.getRoot());
        System.out.println("-------------");
    }

    @Test
    @Order(4)
    void dfs() {
        System.out.println("-----dfs-----");
        bt.dfs(bt.getRoot());
        System.out.println("-------------");
    }

    @Test
    @Order(5)
    void deleteNode() {
        assertEquals(bt.delete(1), 1);
        assertEquals(bt.delete(5), 5);
        assertEquals(bt.getSize(),3);
    }

    @Test
    @Order(6)
    void deleteNodeFail() {
        assertThrows(RuntimeException.class, () -> bt.delete(21));
    }

}