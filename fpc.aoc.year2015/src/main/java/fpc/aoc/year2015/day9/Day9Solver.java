package fpc.aoc.year2015.day9;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day9Solver extends SmartSolver<Input> {

  @Override
  protected @NonNull Converter<Input> getConverter() {
    return Converter.forItem(Path::parse).andThen(Input::create);
  }
}
