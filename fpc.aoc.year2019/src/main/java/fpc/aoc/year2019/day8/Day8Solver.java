package fpc.aoc.year2019.day8;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.List;

public abstract class Day8Solver extends SmartSolver<String> {


  @Override
  protected Object doSolve(String input) {
    final EncodedLayers encodedLayers = new EncodedLayers(input, 25, 6);
    return solve(encodedLayers.decode());
  }

  @Override
  protected Converter<String> getConverter() {
    return Converter.FIRST_LINE;
  }

  protected abstract Object solve(List<Layer> layers);
}
