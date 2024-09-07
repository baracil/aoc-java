package fpc.aoc.year2015.day15;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.function.LongPredicate;

public abstract class Day15Solver extends SmartSolver<Input> {

  @Override
  protected @NonNull Converter<Input> getConverter() {
    return Input::parse;
  }


  protected abstract LongPredicate getCaloriePredicate();

  @Override
  public @NonNull Long doSolve(@NonNull Input input) {
    return input.getProd(getCaloriePredicate());

  }


}
