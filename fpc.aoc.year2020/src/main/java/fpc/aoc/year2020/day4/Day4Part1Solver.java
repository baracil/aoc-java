package fpc.aoc.year2020.day4;

import fpc.aoc.api.Solver;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day4.structures.Passport;
import fpc.aoc.year2020.day4.structures.PassportListBuilder;
import fpc.aoc.year2020.day4.structures.WithCIDOptional;
import lombok.NonNull;

import java.util.List;

public class Day4Part1Solver extends SmartSolver<List<Passport>> {

  public static @NonNull Solver provider() {
    return new Day4Part1Solver();
  }

  @Override
  protected @NonNull Converter<List<Passport>> getConverter() {
    return PassportListBuilder::build;
  }

  @Override
  public @NonNull Long doSolve(@NonNull List<Passport> passports) {
    final var validityRule = new WithCIDOptional();
    return passports.stream()
        .filter(validityRule::isValid)
        .count();
  }
}
