package fpc.aoc.year2020.day11.structures;

import lombok.NonNull;

public interface StateEvolutionRule {

  @NonNull
  State evaluateNewSate(@NonNull State current, long numberOfAdjacentOccupiedSeats);
}
