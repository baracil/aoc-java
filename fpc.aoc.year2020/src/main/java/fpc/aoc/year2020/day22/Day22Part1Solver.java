package fpc.aoc.year2020.day22;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day22.structures.CrabCombatRules;
import fpc.aoc.year2020.day22.structures.GameRules;
import lombok.NonNull;

public class Day22Part1Solver extends Day22Solver {

  public static @NonNull Solver provider() {
    return new Day22Part1Solver();
  }

  @Override
  protected @NonNull GameRules getGameRules() {
    return new CrabCombatRules();
  }
}
