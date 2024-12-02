package fpc.aoc.year2022.day5;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Day5Solver extends SmartSolver<Input5> {

  @Override
  protected Converter<Input5> getConverter() {
    return s -> s.stream().collect(Input5.COLLECTOR);
  }

  private final CrateMover crateMover;

  @Override
  public String doSolve(Input5 input) {
    final var stacks = input.stacks();
    input.steps().forEach(p -> crateMover.performProcedureStep(stacks, p));
    return stacks.listTopOfStacks();
  }
}
