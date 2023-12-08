package fpc.aoc.day7;

import fpc.aoc.day7.model.Hand;
import fpc.aoc.day7.model.HandParser;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day7Solver extends SmartSolver<Stream<String>, Long> {

  protected abstract HandParser createHandParser();

  @Override
  public @NonNull Long solve(@NonNull Stream<String> input) {
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
    return Converter.IDENTITY;
  }
}
