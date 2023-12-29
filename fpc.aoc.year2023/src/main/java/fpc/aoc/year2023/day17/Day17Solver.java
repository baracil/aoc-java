package fpc.aoc.year2023.day17;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Orientation;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day17Solver extends SmartSolver<ArrayOfChar> {

  @Override
  protected @NonNull Converter<ArrayOfChar> getConverter() {
    return Converter.TO_ARRAY_OF_CHAR;
  }

  protected abstract Helper createHelper(@NonNull ArrayOfChar input);

  @Override
  public @NonNull Object doSolve(@NonNull ArrayOfChar input) {
    return find(createHelper(input)).totalHeatLoss();
  }

  private Step find(Helper helper) {
    final var walker = new Walker();

    int bestSoFar = Integer.MAX_VALUE;
    Step end = null;

    walker.handleNew(helper.first());
    while (walker.hasToDo()) {
      final var step = walker.next();
      for (Orientation orientation : Orientation.allValues()) {
        final var s = helper.move(step, orientation);
        if (s == null) {
          continue;
        }
        if (helper.endReached(s)) {
          if (end == null || end.totalHeatLoss() > s.totalHeatLoss()) {
            end = s;
            bestSoFar = end.totalHeatLoss();
          }
        }
        if (s.heuristic() < bestSoFar) {
          walker.handleNew(s);
        }
      }
    }
    if (end == null) {
      throw new AOCException("To stupid to solve this");
    }
    return end;
  }


}
