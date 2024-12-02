package fpc.aoc.year2020.day22;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day22.structures.GameRules;
import fpc.aoc.year2020.day22.structures.RecursiveCombatRules;

public class Day22Part2Solver extends Day22Solver {

  public static Solver provider() {
    return new Day22Part2Solver();
  }

  @Override
  protected GameRules getGameRules() {
    return new RecursiveCombatRules();
  }
}
