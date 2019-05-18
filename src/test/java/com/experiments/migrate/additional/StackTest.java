package com.experiments.migrate.additional;

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

  @Test
  public void addOneElementSize_thenEqualsOne() {
    Stack s = new Stack();
    s.add(15);
    assertEquals(1, s.size());
  }

  @Test
  public void addTenElementSize_thenEqualsTen() {
    Stack s = new Stack();
    for (int i = 0; i < 10; i++) {
      s.add(15);
    }
    assertEquals(10, s.size());
  }

  @Test
  public void addOneElementAndPeek_thenSuccess() {
    Stack s = new Stack();
    s.add(15);
    assertEquals(15, s.peek()._2);
  }

  @Test
  public void addTwoElements_thenSuccess() {
    Stack s = new Stack();
    s.add(15);
    s.add(20);
    assertEquals(20, s.peek()._2);
  }

  @Test
  public void addAndPopOneElement_thenSuccess() {
    Stack s = new Stack();
    s.add(15);
    Pair<Integer, Integer> val = s.pop();
    assertEquals(15, val._2);
  }

  @Test
  public void peekBottomEmptyStack_thenFail() {
    Stack s = new Stack();
    assertThrows(IndexOutOfBoundsException.class, () ->
            s.peekBottom());
  }

  @Test
  public void peekBottomNonEmptyStack_thenSuccess() {
    Stack s = new Stack();
    s.push(1);
    assertEquals(1, s.peekBottom()._2);
    s.push(0);
    assertEquals(1, s.peekBottom()._2);
  }

  @Test
  public void getAsArrayEmpty_thenSuccess() {
    Stack s = new Stack();
    assertArrayEquals(new Pair[]{}, s.getAsArray());
  }

  @Test
  public void getAsArrayPopulated_thenSuccess() {
    Stack s = new Stack();
    s.push(2);
    s.push(1);
    s.push(0);
    Pair cont[] = s.getAsArray();
    assertEquals(0, cont[0]._2);
    assertEquals(1, cont[1]._2);
    assertEquals(2, cont[2]._2);
  }
}
