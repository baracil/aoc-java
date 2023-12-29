package fpc.aoc.year2020.day22.structures;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CrabCombatRules implements GameRules {

    public @NonNull Player getWinnerOfRound(@NonNull GameState gameState) {
        final int card1 = gameState.firstCardOf(Player.ONE);
        final int card2 = gameState.firstCardOf(Player.TWO);
        return card1>card2?Player.ONE:Player.TWO;
    }

}
