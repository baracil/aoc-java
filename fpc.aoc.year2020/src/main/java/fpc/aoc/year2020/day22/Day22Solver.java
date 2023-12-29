package fpc.aoc.year2020.day22;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day22.structures.GameExecutor;
import fpc.aoc.year2020.day22.structures.GameRules;
import fpc.aoc.year2020.day22.structures.GameState;
import fpc.aoc.year2020.day22.structures.Score;
import lombok.NonNull;

public abstract class Day22Solver extends SmartSolver<GameState> {

  @Override
  protected @NonNull Converter<GameState> getConverter() {
    return GameState::parse;
  }

  protected abstract @NonNull GameRules getGameRules();

  @Override
  public final @NonNull Score doSolve(@NonNull GameState state) {
    final var rules = getGameRules();
    final var gameExecutor = new GameExecutor(rules);

    final var outcome = gameExecutor.play(state);

    return outcome.score();

  }
}
