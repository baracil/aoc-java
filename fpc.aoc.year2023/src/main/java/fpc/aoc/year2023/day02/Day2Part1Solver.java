package fpc.aoc.year2023.day02;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day2Part1Solver extends Day2Solver {

  public static @NonNull Solver provider() {
    return new Day2Part1Solver();
  }

  public static final Pick MAX = new Pick(12, 13, 14);

  @Override
  public @NonNull Object doSolve(@NonNull Stream<Game> input) {
    return input.filter(game -> game.isValid(MAX)).mapToInt(Game::id).sum();
  }
}
