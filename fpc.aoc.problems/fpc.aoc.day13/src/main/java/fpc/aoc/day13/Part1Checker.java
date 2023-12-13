package fpc.aoc.day13;

public class Part1Checker implements Checker {

  @Override
  public boolean check(long[] lines, int idx1, int idx2) {
    while (idx1 < idx2) {
      if (lines[idx1] != lines[idx2]) {
        return false;
      }
      idx1++;
      idx2--;
    }
    return idx1 != idx2;
  }
}
