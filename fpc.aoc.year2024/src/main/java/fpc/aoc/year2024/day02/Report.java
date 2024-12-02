package fpc.aoc.year2024.day02;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Report {

  private final int[] levels;


  public boolean isSafePart2() {
    for (int i = -1; i <levels.length ; i++) {
      if (isSafe(i)) {
        return true;
      }
    }
    return false;
  }

  public boolean isSafePart1() {
    return isSafe(-1);
  }

  public boolean isSafe(int skipped) {
    int low = skipped ==0?1:0;

    while (low < levels.length) {
      int high = low+1;

      if (high == skipped) {
        high++;
      }
      if (high>=levels.length) {
        break;
      }
      final var d = levels[high]-levels[low];
      if (d<1 || d>3) {
        return false;
      }

      low++;
      if (low==skipped) {
        low++;
      }
    }
    return true;
  }


  public static Report parse(String line) {
    final var levels = Arrays.stream(line.split(" +"))
        .mapToInt(Integer::parseInt)
        .toArray();

    final var length = levels.length;
    if (levels[0]>levels[length-1]) {
      for (int i = 0,j=length-1; i < j; i++,j--) {
        final var s = levels[i];
        levels[i] = levels[j];
        levels[j]=s;
      }
    }
    return new Report(levels);
  }


}
