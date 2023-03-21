package ru.spbu.apcyb.svp.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Тесты Task 2.
 */
class ListStackTest {

  ListStack stack = new ListStack();

  @Test
  void peek() {
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(5);
    assertEquals(5, stack.peek());
  }

  @Test
  void push1() {
    assertEquals(5, stack.push(5));
  }

  @Test
  void push2() {
    stack.push(1);
    stack.push(2);
    stack.push(3);
    assertEquals(3, stack.peek());
  }

  @Test
  void pop() {
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.pop());
  }

  @Test
  void isEmpty() {
    assertTrue(stack.isEmpty());
  }

}
