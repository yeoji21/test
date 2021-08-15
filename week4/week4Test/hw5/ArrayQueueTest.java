package com.example.answer.week4.hw5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ArrayQueueTest {

    ArrayQueue queue = new ArrayQueue();

    @Test
    @Order(1)
    @DisplayName("add 메소드 성공")
    void add() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        assertEquals(queue.getSize(), 5);
    }

    @Test
    @Order(2)
    @DisplayName("add 메소드 실패")
    void addFail() {
        assertThrows(RuntimeException.class, () -> queue.add(6));
    }

    @Test
    @Order(3)
    @DisplayName("remove 메소드 성공")
    void remove() {
        int first = queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        int last = queue.remove();
        assertEquals(first, 1);
        assertEquals(last, 5);
        assertEquals(queue.getSize(), 0);
    }

    @Test
    @Order(3)
    @DisplayName("remove 메소드 실패")
    void removeFail() {
        assertThrows(RuntimeException.class, () -> queue.remove());
    }
}