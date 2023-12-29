package fpc.aoc.year2021.day10;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Pair;
import fpc.aoc.year2021.day10.structures.CompleterChecker;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class Day10Part2Solver extends Day10Solver {

  public static @NonNull Solver provider() {
    return new Day10Part2Solver();
  }

  @Override
  public @NonNull String doSolve(@NonNull Stream<String> input) {
    final var scores = input.map(this::complete)
//                                .peek(p -> System.out.printf("%s -> %s%n", p.first(), p.second()))
        .flatMap(p -> p.second().stream())
        .sorted()
        .toArray();

    return scores[scores.length / 2].toString();
  }

  public @NonNull Pair<String, Optional<BigInteger>> complete(@NonNull String line) {
    final var score = CompleterChecker.create().complete(line);
    return Pair.of(line, score);
  }
}




