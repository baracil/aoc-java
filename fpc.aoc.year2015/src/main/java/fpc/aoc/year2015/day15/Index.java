package fpc.aoc.year2015.day15;

public class Index {
  private final long[] factors;
  private final int lastIdx;
  private long sum;

  public long factor(int idx) {
    return factors[idx];
  }

  public Index(int nbFactors, long total) {
    this.factors = new long[nbFactors];
    this.sum = total;
    this.lastIdx = nbFactors - 1;
  }

  public boolean increment() {
    int idx = 0;
    do {
      factors[idx]++;
      sum -= 1;
      if (sum < 0) {
        sum += factors[idx];
        factors[idx] = 0;
      } else {
        factors[lastIdx] = sum;
        return true;
      }
      idx++;
    } while (idx < lastIdx);
    return false;
  }
}
