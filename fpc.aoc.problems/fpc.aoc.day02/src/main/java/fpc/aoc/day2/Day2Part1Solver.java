package fpc.aoc.day2;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day2Part1Solver extends Day2Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day2Part1Solver().createProblem();
    }

    public static final Pick MAX = new Pick(12,13,14);

    @Override
    public @NonNull Integer solve(@NonNull Stream<Game> input) {
      return input.filter(game -> game.isValid(MAX)).mapToInt(Game::id).sum();
    }
}
