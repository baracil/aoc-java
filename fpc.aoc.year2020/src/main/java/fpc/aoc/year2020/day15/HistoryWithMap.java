package fpc.aoc.year2020.day15;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class HistoryWithMap implements History {

  private final Map<Integer, NumberHistory> numberHistories = new HashMap<>();

  @Override
  public @NonNull NumberHistory get(int lastSpoken) {
    return numberHistories.get(lastSpoken);
  }

  @Override
  public void initialize(int[] initialNumbers) {
    for (int turn = 0; turn < initialNumbers.length; turn++) {
      numberHistories.put(initialNumbers[turn], new NumberHistory(initialNumbers[turn], turn));
    }
  }

  @Override
  public void updateNumberHistory(int number, int turnIndex) {
    numberHistories.computeIfAbsent(number, l -> new NumberHistory(number, turnIndex)).setLastSpokenTurn(turnIndex);
  }
}
