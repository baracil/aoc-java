package fpc.aoc.year2021.day13;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2021.day13.struct.Input;
import lombok.NonNull;

public abstract class Day13Solver extends SmartSolver<Input> {

  @Override
  protected @NonNull Converter<Input> getConverter() {
    return Converter.IDENTITY.andThen(s -> s.stream().collect(Input.COLLECTOR));
  }


}
