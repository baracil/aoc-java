package fpc.aoc.year2020.day11.structures;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.GridHelper;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;

public class SeatLayoutLife {

  private final @NonNull StateEvolutionRule stateEvolutionRule;
  private final @NonNull AdjacentCounter adjacentCounter;
  private final @NonNull State[] states;
  @Getter
  private final @NonNull SeatLayout layout;

  private final long[] nbOccupiedBuffer;

  public SeatLayoutLife(@NonNull GridHelper gridHelper,
                        @NonNull StateEvolutionRule stateEvolutionRule,
                        @NonNull AdjacentCounter adjacentCounter,
                        @NonNull ArrayOfChar input) {
    this.stateEvolutionRule = stateEvolutionRule;
    this.adjacentCounter = adjacentCounter;
    final var width = input.width();
    final var height = input.height();

    nbOccupiedBuffer = new long[width * height];

    {
      this.states = new State[width * height];
      Arrays.fill(states, State.FLOOR);
      gridHelper.allPositionOnGrid()
          .filter(p -> input.get(p) == 'L')
          .forEach(p -> states[p.linearIndex(width)] = State.EMPTY_SEAT);
      this.layout = new SeatLayoutUsingArray(states, width, height);
    }
  }

  /**
   * @return true if any changed occurred
   */
  public boolean evolving() {
    adjacentCounter.updateOccupationMap(this.layout, this.nbOccupiedBuffer);

    boolean anyChange = false;
    for (int i = 0; i < nbOccupiedBuffer.length; i++) {
      final long nbOccupied = nbOccupiedBuffer[i];
      final State oldState = states[i];
      states[i] = stateEvolutionRule.evaluateNewSate(oldState, nbOccupied);
      if (oldState != states[i]) {
        anyChange = true;
      }
    }

    return anyChange;
  }

  public long totalNumberOfOccupiedSeats() {
    return layout.totalNumberOfOccupiedSeats();
  }
}
