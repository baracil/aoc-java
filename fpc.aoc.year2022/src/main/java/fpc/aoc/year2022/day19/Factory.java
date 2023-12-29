package fpc.aoc.year2022.day19;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Factory {

  public static State findBest(@NonNull BluePrint bluePrint, int nbRound) {
    return new Factory(bluePrint, nbRound).findBest();
  }

  private final BluePrint bluePrint;
  private final int nbRound;

  private long best = -1;

  private State findBest() {
    return findBest(State.initial(bluePrint));
  }


  private State findBest(State state) {
    if (state.time() == nbRound) {
      best = Math.max(best, state.nbGeode());
      return state;
    }


    final long atmost = state.atMost(Type.GEODE, nbRound);
    if (atmost <= best) {
      return null;
    }

    return state.next(nbRound)
        .map(this::findBest)
        .reduce(null, this::best);
  }


  public State best(State s1, State s2) {
    if (s1 == null) {
      return s2;
    }
    if (s2 == null || s2.nbGeode() < s1.nbGeode()) {
      return s1;
    }
    return s2;
  }
}
