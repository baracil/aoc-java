package fpc.aoc.common;

import java.util.Arrays;

public class Top {
  private final long[] top;

  public long sum() {
    return Arrays.stream(top).sum();
  }

  public long product() {
    return Arrays.stream(top).reduce(1, (a, b) -> a * b);
  }

  public Top(int n) {
    this.top = new long[n];
    Arrays.fill(this.top, -1);
  }


  public void handle(long l) {
    if (l <= top[0]) {
      return;
    }

    boolean set = false;
    for (int i = 1; i < top.length; i++) {
      if (l > top[i]) {
        top[i - 1] = top[i];
      } else {
        top[i - 1] = l;
        set = true;
        break;
      }
    }
    if (!set) {
      top[top.length - 1] = l;
    }
  }
}
