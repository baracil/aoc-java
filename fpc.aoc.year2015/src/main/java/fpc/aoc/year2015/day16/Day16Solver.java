package fpc.aoc.year2015.day16;

import fpc.aoc.common.AOCException;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day16Solver extends SmartSolver<Stream<Sue>> {

  @Override
  protected @NonNull Converter<Stream<Sue>> getConverter() {
    return Converter.forStreamOfItems(Sue::parse);
  }

  protected abstract TestFactory createTestFactory();


  @Override
  public @NonNull String doSolve(@NonNull Stream<Sue> input) {
    final var clue = Clue.create(createTestFactory());

    final var list = input.filter(clue::matches).toList();
    if (list.size() != 1) {
      throw new AOCException("Fail : "+ list.size());
    }
    return list.getFirst().index();
  }
}
