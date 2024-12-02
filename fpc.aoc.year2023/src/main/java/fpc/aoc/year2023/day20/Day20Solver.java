package fpc.aoc.year2023.day20;


import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2023.day20.model.Circuit;
import fpc.aoc.year2023.day20.model.Module;

public abstract class Day20Solver extends SmartSolver<Circuit> {

  @Override
  protected Converter<Circuit> getConverter() {
    return Converter.forItem(Module::parse).andThen(Circuit::create);
  }
}
