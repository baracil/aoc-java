package fpc.aoc.common;

import lombok.NonNull;

public interface GameOfLifeRule<T> {

  @NonNull
  CellState computeNewState(@NonNull CellState previousState, int nbNeighbour, T position);

  GameOfLifeRule<Object> DEFAULT_RULE = (current, neighbour, position) -> {
    if (neighbour == 3) {
      return CellState.ALIVE;
    } else if (neighbour == 2) {
      return current;
    }
    return CellState.DEAD;
  };
}

