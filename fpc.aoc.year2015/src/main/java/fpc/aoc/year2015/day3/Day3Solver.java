package fpc.aoc.year2015.day3;

import fpc.aoc.common.Displacement;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.List;

public abstract class Day3Solver extends SmartSolver<List<Displacement>> {

  @Override
  protected Converter<List<Displacement>> getConverter() {
    return Converter.FIRST_LINE.andThen(s -> s.chars().mapToObj(this::toDisplacement).toList());
  }

  private Displacement toDisplacement(int c) {
    return switch (c) {
      case '^' -> Displacement.N;
      case 'v' -> Displacement.S;
      case '<' -> Displacement.W;
      case '>' -> Displacement.E;
      default -> throw new IllegalArgumentException("Invalid char '"+c+"'");
    };
  }
}
