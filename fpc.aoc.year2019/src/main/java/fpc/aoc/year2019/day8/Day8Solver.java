package fpc.aoc.year2019.day8;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.List;

public abstract class Day8Solver extends SmartSolver<String> {


  @Override
  protected @NonNull Object doSolve(@NonNull String input) {
    final EncodedLayers encodedLayers = new EncodedLayers(input, 25, 6);
    return solve(encodedLayers.decode());
  }

  @Override
  protected @NonNull Converter<String> getConverter() {
    return Converter.FIRST_LINE;
  }

  protected abstract Object solve(@NonNull List<Layer> layers);
}
