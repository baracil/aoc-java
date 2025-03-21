package fpc.aoc.year2015.day7;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2015.day7.data.Circuit;
import fpc.aoc.year2015.day7.data.Operator;

public abstract class Day7Solver extends SmartSolver<Circuit> {

  @Override
  protected Converter<Circuit> getConverter() {
    return Converter.forItem(Operator::parse).andThen(Circuit::create);
  }
}
