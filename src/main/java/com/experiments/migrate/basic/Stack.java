package com.experiments.migrate.basic;

import com.experiments.Pair;

public class Stack {
  private class Node {
    private final Node below;
    private final int index;
    private final int value;

    public Node(Node below, int index, int value) {
      this.below = below;
      this.index = index;
      this.value = value;
    }

    public Pair<Integer, Integer> get() {
      return new Pair<>(index, value);
    }
  }

  private Node top;
  private int size;

  public Stack() {
    top = null;
    size = 0;
  }

  public void push(int value) {
    Node n = new Node(top, size, value);
    top = n;
    size++;
  }

  public Pair<Integer, Integer> pop() throws IndexOutOfBoundsException {
    try {
      Pair<Integer, Integer> val = top.get();
      top = top.below;
      size--;
      return val;
    } catch (NullPointerException e) {
      throw new IndexOutOfBoundsException("Stack is empty");
    }
  }

  public Pair<Integer, Integer> peek() throws IndexOutOfBoundsException {
    try {
      return top.get();
    } catch (NullPointerException e) {
      throw new IndexOutOfBoundsException("Stack is empty");
    }
  }

  public int size() {
    return size;
  }
}
