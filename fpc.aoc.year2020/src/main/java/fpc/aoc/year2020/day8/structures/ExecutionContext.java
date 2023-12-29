package fpc.aoc.year2020.day8.structures;

import lombok.NonNull;

/**
 * @param pointer Position of the next instruction to execute
 */
public record ExecutionContext(int accumulator, int pointer) {

  public static @NonNull ExecutionContext createInitial() {
    return new ExecutionContext(0, 0);
  }

  public ExecutionContext moveBy(int offset) {
    return new ExecutionContext(accumulator, pointer + offset);
  }

  public ExecutionContext addToAccumulator(int increment) {
    return new ExecutionContext(accumulator + increment, pointer);
  }
}
