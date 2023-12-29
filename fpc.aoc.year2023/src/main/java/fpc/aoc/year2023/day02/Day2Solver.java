package fpc.aoc.year2023.day02;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public abstract class Day2Solver extends SmartSolver<Stream<Game>> {

  @Override
  protected @NonNull Converter<Stream<Game>> getConverter() {
    return s -> s.stream().map(Game::parse);
  }
}
