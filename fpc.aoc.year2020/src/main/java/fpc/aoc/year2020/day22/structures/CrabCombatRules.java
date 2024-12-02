package fpc.aoc.year2020.day22.structures;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CrabCombatRules implements GameRules {

  public Player getWinnerOfRound(GameState gameState) {
    final int card1 = gameState.firstCardOf(Player.ONE);
    final int card2 = gameState.firstCardOf(Player.TWO);
    return card1 > card2 ? Player.ONE : Player.TWO;
  }

}
