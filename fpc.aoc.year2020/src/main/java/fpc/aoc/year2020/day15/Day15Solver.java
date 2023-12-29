package fpc.aoc.year2020.day15;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.Arrays;

public abstract class Day15Solver extends SmartSolver<int[]> {

  @Override
  protected @NonNull Converter<int[]> getConverter() {
    return Converter.FIRST_LINE.andThen(this::toArrayOfNumbers);
  }

  private int[] toArrayOfNumbers(@NonNull String line) {
    return Arrays.stream(line.split(","))
        .mapToInt(Integer::parseInt)
        .toArray();
  }

  protected abstract int getNumberOfTurns();

  public History createHistory(int size) {
    return new HistoryWithArray(size);
  }

  public Integer doSolve(int[] input) {
    final var nbTurns = getNumberOfTurns();
    final var history = createHistory(nbTurns);

    history.initialize(input);
    int lastSpoken = input[input.length - 1];
    for (int turn = input.length; turn < nbTurns; turn++) {
      final var nextToSay = history.get(lastSpoken).getNextToSay();
      history.updateNumberHistory(nextToSay, turn);
      lastSpoken = nextToSay;
    }
    return lastSpoken;
  }

}
