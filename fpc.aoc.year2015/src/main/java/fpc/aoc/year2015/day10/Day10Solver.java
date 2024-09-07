package fpc.aoc.year2015.day10;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day10Solver extends SmartSolver<String> {

  @Override
  protected @NonNull Converter<String> getConverter() {
    return Converter.FIRST_LINE;
  }

  protected abstract int nbIterations();

  @Override
  public @NonNull Integer doSolve(@NonNull String input) {
    String result = input;
    for (int i = 0; i < nbIterations(); i++) {
      result = LookAndSay.oneStep(result);
    }
    return result.length();
  }

}
