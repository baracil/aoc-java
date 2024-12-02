package fpc.aoc.year2022.day16;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2022.day16._private.Network;

public abstract class Day16Solver extends SmartSolver<Valves> {

  @Override
  protected Converter<Valves> getConverter() {
    return s -> s.stream().collect(Network.NetworkAggregator.COLLECTOR);
  }
}
