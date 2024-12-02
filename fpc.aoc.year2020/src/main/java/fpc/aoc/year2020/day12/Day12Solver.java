package fpc.aoc.year2020.day12;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day12.structures.Movement;

import java.util.List;

public abstract class Day12Solver extends SmartSolver<List<Movement>> {

  @Override
  protected Converter<List<Movement>> getConverter() {
    return Converter.forItem(Movement::parse);
  }
}
