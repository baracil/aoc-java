package fpc.aoc.year2023.day07;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2023.day07.model.Hand;
import fpc.aoc.year2023.day07.model.HandParser;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day7Solver extends SmartSolver<Stream<String>> {

  protected abstract HandParser createHandParser();

  @Override
  public @NonNull Object doSolve(@NonNull Stream<String> input) {
    final var parser = createHandParser();
    final var list = input.map(parser).sorted(Hand.COMPARATOR).toList();

    long score = 0;
    for (int i = 0; i < list.size(); i++) {
      final var factor = i + 1L;
      score += (factor * list.get(i).bid());
    }

    return score;
  }

  @Override
  protected @NonNull Converter<Stream<String>> getConverter() {
    return Converter.TO_STREAM;
  }
}
