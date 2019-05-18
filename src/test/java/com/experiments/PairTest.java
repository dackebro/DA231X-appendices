package com.experiments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PairTest {
  @Test
  public void createIntIntPair_thenSuccess() {
    Pair<Integer, Integer> pair = new Pair<>(0, 5);
    assertEquals(0, pair._1);
    assertEquals(5, pair._2);
    assertEquals("(0, 5)", pair.toString());
  }

  @Test
  public void createIntStringPair_thenSuccess() {
    Pair<Integer, String> pair = new Pair<>(0, "value");
    assertEquals(0, pair._1);
    assertEquals("value", pair._2);
    assertEquals("(0, value)", pair.toString());
  }

  @Test
  public void pairEquals_thenSuccess() {
    assertEquals(new Pair<>(0, 1),
            new Pair<>(0, 1));
    assertNotEquals(new Pair<>(1, 1),
            new Pair<>(0, 1));
    assertNotEquals(new Pair<>(0, 1),
            new Pair<>(0, 2));
  }
}
