package fpc.aoc.year2020.day22;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day22.structures.GameExecutor;
import fpc.aoc.year2020.day22.structures.GameRules;
import fpc.aoc.year2020.day22.structures.GameState;
import fpc.aoc.year2020.day22.structures.Score;

public abstract class Day22Solver extends SmartSolver<GameState> {

  @Override
  protected Converter<GameState> getConverter() {
    return GameState::parse;
  }

  protected abstract GameRules getGameRules();

  @Override
  public final Score doSolve(GameState state) {
    final var rules = getGameRules();
    final var gameExecutor = new GameExecutor(rules);

    final var outcome = gameExecutor.play(state);

    return outcome.score();

  }
}
