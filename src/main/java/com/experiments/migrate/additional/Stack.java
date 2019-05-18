package com.experiments.migrate.additional;

import com.experiments.Pair;

public class Stack {
  private class Node {
    private Node below;
    private int index;
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

  private Node bottom;
  private Node top;
  private int size;

  public Stack() {
    bottom = null;
    top = null;
    size = 0;
  }

  private Node getAt(int indexFromTop) throws IndexOutOfBoundsException {
    if (indexFromTop < 0 || indexFromTop >= size) {
      throw new IndexOutOfBoundsException("Index don't exist");
    }
    Node n = top;
    for (int i = 0; i < indexFromTop; i++) {
      n = n.below;
    }
    return n;
  }

  public void push(int value) {
    Node n = new Node(top, size, value);
    top = n;
    if (size == 0) {
      bottom = n;
    }
    size++;
  }

  public void add(int value) {
    push(value);
  }

  public void add(int value, int indexFromTop) throws IndexOutOfBoundsException {
    if (indexFromTop == 0) {
      push(value);
      return;
    }
    Node pre = getAt(indexFromTop - 1);
    Node insert = new Node(pre.below, size - indexFromTop, value);
    pre.below = insert;
    size++;
    if (pre == bottom) {
      bottom = insert;
    }
    Node n = top;
    while (n != insert) {
      n.index++;
      n = n.below;
    }
  }

  public Pair<Integer, Integer> pop() throws IndexOutOfBoundsException {
    try {
      Pair<Integer, Integer> val = top.get();
      top = top.below;
      size--;
      if (size == 0) {
        bottom = null;
      }
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

  public Pair<Integer, Integer> peekBottom() throws IndexOutOfBoundsException {
    try {
      return bottom.get();
    } catch (NullPointerException e) {
      throw new IndexOutOfBoundsException("Stack is empty");
    }
  }

  public Pair<Integer, Integer> peekAt(int indexFromTop) {
    return getAt(indexFromTop).get();
  }

  public Pair<Integer, Integer>[] getAsArray() {
    Pair<Integer, Integer>[] value = new Pair[size];
    Node n = top;
    for (int i = 0; i < size; i++) {
      value[i] = n.get();
      n = n.below;
    }
    return value;
  }

  public int size() {
    return size;
  }
}
