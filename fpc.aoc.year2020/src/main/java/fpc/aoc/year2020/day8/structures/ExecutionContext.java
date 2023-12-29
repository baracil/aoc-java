package fpc.aoc.year2020.day8.structures;

import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@Value
public class ExecutionContext {

  public static @NonNull ExecutionContext createInitial() {
    return new ExecutionContext(0, 0);
  }

  @Getter
  int accumulator;
  /**
   * Position of the next instruction to execute
   */
  @Getter
  int pointer;

  public ExecutionContext moveBy(int offset) {
    return new ExecutionContext(accumulator, pointer + offset);
  }

  public ExecutionContext addToAccumulator(int increment) {
    return new ExecutionContext(accumulator + increment, pointer);
  }
}
