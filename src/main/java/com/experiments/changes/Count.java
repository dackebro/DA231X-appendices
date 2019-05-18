package com.experiments.changes;

public class Count {
  int sum = 0;
  Object lock = new Object();

  class Counter implements Runnable {
    int threadTarget;
    public Counter(int threadTarget) {
      this.threadTarget = threadTarget;
    }

    @Override
    public void run() {
      synchronized (this) {
        for (int i = 0; i < threadTarget; i++) {
          sum += 1;
        }
      }
    }
  }

  public int parallelCount(int threads, int threadTarget) throws InterruptedException {
    Thread[] thread = new Thread[threads];
    for (int i = 0; i < threads; i++) {
      thread[i] = new Thread(new Counter(threadTarget));
    }
    for (int i = 0; i < threads; i++) {
      thread[i].start();
    }
    for (int i = 0; i < threads; i++) {
      thread[i].join();
    }
    return sum;
  }

  /**
   * @param x
   * @param y
   * @return the product of x and y (x * y)
   */
  public static int sequentialCount(int x, int y) {
    int sum = 0;
    for (int i = 0; i <= x; i++) {
      for (int j = 0; j < y; j++) {
        sum++;
      }
    }
    return sum;
  }

  public static int loop(int laps) {
    int sum = 0;

    while (true) {
      sum++;
      if (sum == laps) {
        break;
      }
    }
    return sum;
  }
}
