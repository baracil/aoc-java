package fpc.aoc.year2023.day13;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.List;

public abstract class Day13Solver extends SmartSolver<List<Input>> {

  @Override
  protected Converter<List<Input>> getConverter() {
    return s -> s.stream().collect(Input.COLLECTOR);
  }

  protected abstract Checker createChecker();

  @Override
  public Object doSolve(List<Input> input) {
    final var checker = createChecker();
    return input.stream().mapToInt(i -> i.compute(checker)).sum();
  }
}
