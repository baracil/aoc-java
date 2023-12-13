package fpc.aoc.day13;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.List;

public abstract class Day13Solver extends SmartSolver<List<Input>, Integer> {

  @Override
  protected @NonNull Converter<List<Input>> getConverter() {
    return s -> s.collect(Input.COLLECTOR);
  }

  protected abstract Checker createChecker();

  @Override
  public @NonNull Integer solve(@NonNull List<Input> input) {
    final var checker = createChecker();
    return input.stream().mapToInt(i -> i.compute(checker)).sum();
  }
}
