package com.example.answer.week4.hw2;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LinkedListTest {

    LinkedList linkedList = new LinkedList();

    ListNode containCheckNode;

    @Test
    @Order(1)
    @DisplayName("add 메소드 성공 테스트")
    void add() {
        linkedList.add(linkedList.getHead(), new ListNode(1), 0);
        linkedList.add(linkedList.getHead(), new ListNode(2), 1);
        linkedList.add(linkedList.getHead(), new ListNode(3), 2);
        linkedList.add(linkedList.getHead(), new ListNode(4), 0);
        containCheckNode = linkedList.add(linkedList.getHead(), new ListNode(5), 3);
        assertEquals(linkedList.getSize(),5);
    }

    @Test
    @Order(2)
    @DisplayName("add 메소드 실패 테스트")
    void addError() {
        assertThrows(IllegalArgumentException.class, ()->
                linkedList.add(linkedList.getHead(), new ListNode(6), 6));
    }

    @Test
    @Order(3)
    @DisplayName("remove 메소드 성공 테스트")
    void remove() {
        linkedList.remove(linkedList.getHead(), 2);
        linkedList.remove(linkedList.getHead(), 0);
        assertEquals(linkedList.getSize(),3);
    }

    @Test
    @Order(4)
    @DisplayName("remove 메소드 실패 테스트")
    void removeFail() {
        assertThrows(IllegalArgumentException.class, ()->
                linkedList.remove(linkedList.getHead(), 22));
    }


    @Test
    @Order(5)
    @DisplayName("contains 메소드 테스트")
    void contains() {
        boolean containsTrue = linkedList.contains(linkedList.getHead(), containCheckNode);
        boolean containsFalse = linkedList.contains(linkedList.getHead(), new ListNode(22));
        assertTrue(containsTrue);
        assertFalse(containsFalse);
    }
}