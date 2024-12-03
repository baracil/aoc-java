package fpc.aoc.year2024.day03;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Reducer {

  private final boolean handleDoDont;
  @Getter private long sum = 0;
  private boolean enabled = true;

  public Reducer handle(Operation operation) {
    switch (operation) {
      case Operation.Mult(int left, int right) when enabled -> sum += (long) left * right;
      case Operation.Do _ when handleDoDont -> enabled = true;
      case Operation.Dont _ when handleDoDont -> enabled = false;
      default -> {
      }
    }
    return this;
  }

  public Reducer merge(Reducer b) {
    throw new UnsupportedOperationException();
  }

  public static Reducer reducerForPart1() {
    return new Reducer(false);
  }

  public static Reducer reducerForPart2() {
    return new Reducer(true);
  }
}
