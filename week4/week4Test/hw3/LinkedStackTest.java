package com.example.answer.week4.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LinkedStackTest {

    LinkedStack stack = new LinkedStack();

    @Test
    @Order(1)
    @DisplayName("push 메소드 성공")
    void push() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertThat(stack.getSize()).isEqualTo(5);
        assertThat(stack.sum()).isEqualTo(15);
    }

    @Test
    @Order(2)
    @DisplayName("pop 메소드 성공")
    void pop() {
        stack.pop();
        stack.pop();
        int check = stack.pop();
        assertEquals(check, 3);
        assertEquals(stack.getSize(), 2);
    }

    @Test
    @Order(3)
    @DisplayName("pop 메소드 실패")
    void popFail() {
        stack.pop();
        stack.pop();
        assertThrows(RuntimeException.class, () ->
                stack.pop());
    }



}