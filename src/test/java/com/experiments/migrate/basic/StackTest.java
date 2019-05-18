package com.experiments.migrate.basic;

import com.experiments.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
  @Test
  public void createEmptyStack_thenSuccess() {
    Stack s = new Stack();
  }

  @Test
  public void emptyStackSize_thenEqualsZero() {
    Stack s = new Stack();
    assertEquals(0, s.size());
  }

  @Test
  public void pushOneElementSize_thenEqualsOne() {
    Stack s = new Stack();
    s.push(15);
    assertEquals(1, s.size());
  }

  @Test
  public void pushTenElementSize_thenEqualsTen() {
    Stack s = new Stack();
    for (int i = 0; i < 10; i++) {
      s.push(15);
    }
    assertEquals(10, s.size());
  }

  @Test
  public void pushOneElementAndPeek_thenSuccess() {
    Stack s = new Stack();
    s.push(15);
    assertEquals(15, s.peek()._2);
  }

  @Test
  public void pushTwoElements_thenSuccess() {
    Stack s = new Stack();
    s.push(15);
    s.push(20);
    assertEquals(20, s.peek()._2);
  }

  @Test
  public void pushAndPopOneElement_thenSuccess() {
    Stack s = new Stack();
    s.push(15);
    Pair<Integer, Integer> val = s.pop();
    assertEquals(15, val._2);
  }

  @Test
  public void peekEmptyStack_thenFail() {
    Stack s = new Stack();
    assertThrows(IndexOutOfBoundsException.class, () ->
            s.peek());
  }

  @Test
  public void popEmptyStack_thenFail() {
    Stack s = new Stack();
    assertThrows(IndexOutOfBoundsException.class, () ->
            s.pop());
  }
}
