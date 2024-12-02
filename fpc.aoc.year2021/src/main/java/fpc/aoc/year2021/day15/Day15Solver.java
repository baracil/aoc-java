package fpc.aoc.year2021.day15;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2021.day15.struct.Map;
import fpc.aoc.year2021.day15.struct.PathFinder;

public abstract class Day15Solver extends SmartSolver<Map> {

  @Override
  protected Converter<Map> getConverter() {
    return list -> Map.parse(list, getNbRepetitions());
  }


  protected abstract int getNbRepetitions();

  @Override
  public String doSolve(Map input) {
    return String.valueOf(new PathFinder().findLowestRisk(input));
  }
}
