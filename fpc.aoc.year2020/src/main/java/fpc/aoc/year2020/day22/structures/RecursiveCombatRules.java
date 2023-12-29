package fpc.aoc.year2020.day22.structures;

import lombok.NonNull;

public class RecursiveCombatRules implements GameRules {

    private final GameExecutor gameExecutor;
    private final GameRules defaultRules;

    public RecursiveCombatRules() {
        this.gameExecutor = new GameExecutor(this);
        this.defaultRules = new CrabCombatRules();
    }

    @Override
    public @NonNull Player getWinnerOfRound(@NonNull GameState gameState) {
        return gameState.subGameState()
                   .map(r -> gameExecutor.play(r).winner())
                   .orElseGet(() -> defaultRules.getWinnerOfRound(gameState));
    }

}
