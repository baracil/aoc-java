package fpc.aoc.year2020.day7;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day7.structures.BagGraph;
import fpc.aoc.year2020.day7.structures.BagGraphBuilder;
import lombok.NonNull;

public abstract class Day7Solver extends SmartSolver<BagGraph> {

  @Override
  protected @NonNull Converter<BagGraph> getConverter() {
    return BagGraphBuilder::build;
  }
}
