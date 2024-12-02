package fpc.aoc.year2020.day5;


import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day5.structures.BoardingPass;

import java.util.stream.Stream;

public abstract class Day5Solver<O> extends SmartSolver<Stream<BoardingPass>> {

  @Override
  protected Converter<Stream<BoardingPass>> getConverter() {
    return s -> s.stream().map(BoardingPass::create);
  }

}
