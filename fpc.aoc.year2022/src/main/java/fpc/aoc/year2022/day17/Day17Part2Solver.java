package fpc.aoc.year2022.day17;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Day17Part2Solver extends Day17Solver {

  public static @NonNull Solver provider() {
    return new Day17Part2Solver();
  }


  @Override
  public @NonNull Long doSolve(@NonNull Game game) {
    final var turn = doTillRepeat(game);

    long nbTurns = 1000000000000L;
    for (int i = 0; i < turn.nbLeft(nbTurns); i++) {
      game.fallOnePiece();
    }

    return turn.computeTowerHeight(nbTurns, game.getTowerHeight());
  }

  private Repeat doTillRepeat(@NonNull Game game) {
    final Map<Snapshot, TurnInfo> cache = new HashMap<>();

    do {
      final var turnInfo = game.fallOnePiece();

      final var snapshot = turnInfo.snapshot();
      final var previous = cache.get(snapshot);
      if (previous != null) {
        return new Repeat(previous, turnInfo);
      } else {
        cache.put(snapshot, turnInfo);
      }

    } while (true);
  }

  private static class Repeat {
    private final long startIndex;
    private final long length;
    private final long startHeight;
    private final long height;

    public Repeat(@NonNull TurnInfo first, @NonNull TurnInfo second) {
      this.startIndex = first.turnIndex();
      this.startHeight = first.height();
      this.length = second.turnIndex() - first.turnIndex();
      this.height = second.height() - first.height();
    }
    public long nbLeft(long total) {
      return ((total - startIndex) % length) -1;
    }

    public long computeTowerHeight(long nbTurns, long towerHeight) {
      final long factor = (nbTurns - startHeight) / length;
      return towerHeight + (factor - 1) * height;
    }
  }

}
