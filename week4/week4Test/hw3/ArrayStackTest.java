package com.example.answer.week4.hw3;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ArrayStackTest {

    ArrayStack stack = new ArrayStack(5);

    @Test
    @Order(1)
    @DisplayName("push 성공 테스트")
    void push() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        int sum = stack.sum();
        assertThat(sum).isEqualTo(15);
    }

    @Test
    @Order(2)
    @DisplayName("push 실패 테스트")
    void pushFail() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                stack.push(6));
    }

    @Test
    @Order(3)
    @DisplayName("pop 성공 테스트")
    void pop() {
        assertEquals(stack.pop(), 5);
    }

    @Test
    @Order(4)
    @DisplayName("pop 실패 테스트")
    void popFail() {
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                stack.pop());
    }
}