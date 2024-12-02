package fpc.aoc.year2022.day20;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Day20Solver extends SmartSolver<Chain> {

  private final long key;
  private final int nbCycles;

  @Override
  protected Converter<Chain> getConverter() {
    return Converter.TO_ARRAY_OF_INT.andThen(v -> new Chain(v, key));
  }

  @Override
  public Long doSolve(Chain input) {
    for (int i = 0; i < nbCycles; i++) {
      input.performOneCycle();
    }
    return input.getCoordinate();
  }
}
