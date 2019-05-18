package com.experiments.changes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MiscTest {
  @Test
  public void count10Threads_thenSuccess() {
    try {
      int threads = 10;
      int threadTarget = 10000;
      Count c = new Count();
      int res = c.parallelCount(threads, threadTarget);
      assertEquals(threads * threadTarget, res);
    } catch (InterruptedException e) {
      e.printStackTrace();
      fail();
    }
  }

  @Test
  public void sequentialCount_thenCorrect() {
    assertEquals(100, Count.sequentialCount(10, 10));
    assertEquals(250, Count.sequentialCount(25, 10));
  }

  @Test
  public void loopCount_thenCorrect() {
    assertEquals(10, Count.loop(10));
  }

  @Test
  public void stringEqualsCorrect_thenFail() {
    assertFalse(Equals.stringEquals("test"));
    assertFalse(Equals.stringEquals(""));
    assertFalse(Equals.stringEquals(new String("ASCII")));
    assertThrows(NullPointerException.class, () ->
            Equals.stringEquals(null));
  }

  @Test()
  public void guardCountMillion_thenCorrect() {
    Guard g = new Guard();
    assertEquals(1000000, g.guard(1000000));
  }
}


