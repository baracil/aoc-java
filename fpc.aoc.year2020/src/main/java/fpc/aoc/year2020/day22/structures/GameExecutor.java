package fpc.aoc.year2020.day22.structures;

import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class GameExecutor {

  private final GameRules gameRules;

  public GameOutcome play(GameState initialState) {
    return new Execution(initialState).play();
  }

  @RequiredArgsConstructor
  private class Execution {

    private final Set<GameState> seenStates = new HashSet<>();
    private final GameState initialState;
    private GameState currentState;
    private Player currentWinner;

    private GameOutcome play() {
      this.initializeCurrentStateToInitialState();
      while (thereIsNoWinner()) {
        if (currentStateHasBeenSeenAlready()) {
          return outcomeOnLoop();
        }
        this.addCurrentToSeenStates();
        this.findOutCurrentRoundWinner();
        this.updateCurrentStateWithWinner();
      }
      return outcomeOfCurrentState();
    }

    private void initializeCurrentStateToInitialState() {
      this.currentState = this.initialState;
    }

    private boolean currentStateHasBeenSeenAlready() {
      return seenStates.contains(currentState);
    }

    private GameOutcome outcomeOnLoop() {
      return new GameOutcome(Player.ONE, Score.NAS);
    }

    private boolean thereIsNoWinner() {
      return !currentState.isDone();
    }

    private void addCurrentToSeenStates() {
      this.seenStates.add(currentState);
    }

    private void findOutCurrentRoundWinner() {
      this.currentWinner = gameRules.getWinnerOfRound(currentState);
    }

    private void updateCurrentStateWithWinner() {
      this.currentState = this.currentState.nextState(this.currentWinner);
    }

    private GameOutcome outcomeOfCurrentState() {
      return this.currentState.outcome();
    }

  }
}
