package fpc.aoc.year2020.day19;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day19.structures.Day19Input;
import fpc.aoc.year2020.day19.structures.Tester;

public abstract class Day19Solver extends SmartSolver<Day19Input> {

  @Override
  protected Converter<Day19Input> getConverter() {
    return Day19Input::parse;
  }

  protected abstract Day19Input modifyInput(Day19Input input);

  @Override
  public final Long doSolve(Day19Input input) {
    final var modifiedInput = modifyInput(input);
    final var tester = new Tester(modifiedInput.rules());

    return modifiedInput.messages().stream().filter(tester).count();
  }
}
