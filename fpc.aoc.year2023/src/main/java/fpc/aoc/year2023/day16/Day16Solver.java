package fpc.aoc.year2023.day16;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2023.day16.model.BeamComputer;

public abstract class Day16Solver extends SmartSolver<BeamComputer> {

  @Override
  protected Converter<BeamComputer> getConverter() {
    return Converter.TO_ARRAY_OF_CHAR.andThen(BeamComputer::new);
  }
}
