package fpc.aoc.year2020.day22.structures;

import lombok.NonNull;

public interface GameRules {

  @NonNull
  Player getWinnerOfRound(@NonNull GameState gameState);

}
