package fpc.aoc.year2019.day22;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day22Part2Solver extends Day22Solver {

  public static Solver provider() {
    return new Day22Part2Solver();
  }


  @Override
  protected Object doSolve(@NonNull Deck deck) {
    return deck.cardAtPosition(2020);
  }

  @Override
  protected long numberOfRepetitions() {
    return 101741582076661L;
  }

  @Override
  protected long deckSize() {
    return 119_315_717_514_047L;
  }
}
