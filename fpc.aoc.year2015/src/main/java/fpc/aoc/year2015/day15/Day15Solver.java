package fpc.aoc.year2015.day15;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.function.LongPredicate;

public abstract class Day15Solver extends SmartSolver<Input> {

  @Override
  protected Converter<Input> getConverter() {
    return Input::parse;
  }


  protected abstract LongPredicate getCaloriePredicate();

  @Override
  public Long doSolve(Input input) {
    return input.getProd(getCaloriePredicate());

  }


}
