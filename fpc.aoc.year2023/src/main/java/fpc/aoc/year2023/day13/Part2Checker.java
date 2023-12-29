package fpc.aoc.year2023.day13;

public class Part2Checker implements Checker {

  @Override
  public boolean check(long[] lines, int idx1, int idx2) {
    boolean smudgeSeen = false;
    while (idx1 < idx2) {
      final var diff = lines[idx1] ^ lines[idx2];
      if (diff != 0) {
        if (!isPowerOf2(diff) || smudgeSeen) {
          return false;
        }
        smudgeSeen = true;
      }
      idx1++;
      idx2--;
    }
    return idx1 != idx2 && smudgeSeen;
  }


  public boolean isPowerOf2(long v) {
    return (v & (v - 1)) == 0L;
  }
}
