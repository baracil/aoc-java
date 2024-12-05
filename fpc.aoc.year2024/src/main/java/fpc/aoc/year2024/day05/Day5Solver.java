package fpc.aoc.year2024.day05;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class Day5Solver extends SmartSolver<Problem> {

  @Override
  protected Converter<Problem> getConverter() {
    return Converter.collect(Problem.COLLECTOR);
  }

  @Override
  protected final Object doSolve(Problem input) {
    return doSolve(input.updates(),input.constraints());
  }

  protected abstract Object doSolve(List<Update> updates, Contraints contraints);
}
