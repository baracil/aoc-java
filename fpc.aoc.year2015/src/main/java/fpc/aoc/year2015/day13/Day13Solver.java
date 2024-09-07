package fpc.aoc.year2015.day13;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.List;

public abstract class Day13Solver extends SmartSolver<List<Link>> {

  @Override
  protected @NonNull Converter<List<Link>> getConverter() {
    return Converter.forItem(Link::parse);
  }

  protected abstract List<Link> prepare(List<Link> links);

  @Override
  public @NonNull Integer doSolve(@NonNull List<Link> input) {
    final var prepared = prepare(input);
    return SolverDay13.solve(prepared);
  }
}
