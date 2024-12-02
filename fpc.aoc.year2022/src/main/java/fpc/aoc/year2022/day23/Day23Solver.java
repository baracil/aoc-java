package fpc.aoc.year2022.day23;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.GridHelper;
import fpc.aoc.common.Position;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Day23Solver extends SmartSolver<Elves> {

  @Override
  protected Converter<Elves> getConverter() {
    return Converter.TO_ARRAY_OF_CHAR
        .andThen(this::getElfPositions)
        .andThen(s -> s.collect(Collectors.toUnmodifiableSet()))
        .andThen(Elves::new);
  }

  private Stream<Position> getElfPositions(ArrayOfChar arrayOfChar) {
    final var helper = GridHelper.create(arrayOfChar.width(), arrayOfChar.height());
    return helper.allPositionOnGrid()
        .filter(p -> arrayOfChar.get(p) == '#');
  }
}
