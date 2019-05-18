package com.experiments.changes;

public class Guard {
  private int sum;
  private boolean finished;
  private int target;

  private class Counter implements Runnable {
    public void run() {
      for (int i = 0; i < target; i++) {
        sum++;
      }
      finished = true;
    }
  }

  public int guard(int target) {
    sum = 0;
    finished = false;
    this.target = target;
    Thread t = new Thread(new Counter());

    t.start();
    while (!finished) {}

    return sum;
  }
}
