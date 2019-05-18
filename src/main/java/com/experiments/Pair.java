package com.experiments;

import java.util.Objects;

public class Pair<T, S> {
  public final T _1;
  public final S _2;

  public Pair(T _1, S _2) {
    this._1 = _1;
    this._2 = _2;
  }

  public String toString() {
    return "(" + _1 + ", " + _2 + ")";
  }

  @Override
  public boolean equals(final Object rhs) {
    if (rhs == null || getClass() != rhs.getClass()) {
      return false;
    }
    final Pair<T, S> pair = (Pair<T, S>) rhs;
    return Objects.equals(_1, pair._1) &&
            Objects.equals(_2, pair._2);
  }
}
