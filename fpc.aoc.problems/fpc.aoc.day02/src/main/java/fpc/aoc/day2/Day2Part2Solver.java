package fpc.aoc.day2;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day2Part2Solver extends Day2Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day2Part2Solver().createProblem();
  }


  @Override
  public @NonNull Integer solve(@NonNull Stream<Game> input) {
    return input.mapToInt(Game::computePower).sum();
  }
}
