package fpc.aoc.year2020.day10.structures;

import lombok.NonNull;

import java.util.Arrays;

public class LinearCounter implements Part2Counter {

  @Override
  public long count(@NonNull int[] input) {
    return new Execution(input).count();
  }

  private static class Execution {

    private final TriFibonacci triFibonacci = new TriFibonacci();

    private final int[] data;

    public Execution(int[] input) {
      Arrays.sort(input);
      this.data = new int[input.length + 2];

      this.data[0] = 0;
      this.data[data.length - 1] = input[input.length - 1] + 3;
      System.arraycopy(input, 0, this.data, 1, input.length);
    }

    public long count() {
      long count = 1;
      int subChainSize = 1;
      for (int i = 0; i < data.length - 1; i++) {
        int diff = data[i + 1] - data[i];
        if (diff == 1) {
          subChainSize++;
        } else {
          count *= triFibonacci.valueAt(subChainSize);
          subChainSize = 1;
        }
      }
      return count;
    }

  }
}
