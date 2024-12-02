package fpc.aoc.year2021.day4.struct;

import fpc.aoc.common.Position;
import fpc.aoc.common.Tools;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Grid {

  private final Map<Integer, Position> numbers;
  private final int[] columnFilling;
  private final int[] rowFilling;
  @Getter
  private final GridState state;

  public Grid(Map<Integer, Position> numbers, int size) {
    this.numbers = numbers;
    this.columnFilling = new int[size];
    this.rowFilling = new int[size];
    this.state = new GridState.NotWinning();
  }


  public Grid pushOneNumber(int number) {
    if (state instanceof GridState.Winning) {
      return this;
    }

    final var position = this.numbers.get(number);
    if (position == null) {
      return this;
    }
    final var numbers = Tools.removeKey(this.numbers, number);

    final var columnFilling = this.columnFilling.clone();
    final var rowFilling = this.rowFilling.clone();

    final var columnFilled = (++columnFilling[position.y()]) == rowFilling.length;
    final var rowFilled = (++rowFilling[position.x()]) == columnFilling.length;

    final GridState state;
    if (columnFilled || rowFilled) {
      final var score = number * numbers.keySet().stream().mapToInt(i -> i).sum();
      state = new GridState.Winning(score);
    } else {
      state = this.state;
    }

    return new Grid(numbers, columnFilling, rowFilling, state);
  }

  public static Grid from(List<String> gridRows) {
    final var map = new HashMap<Integer, Position>();
    final int size = gridRows.size();
    for (int row = 0; row < size; row++) {
      final var tokens = gridRows.get(row).trim().split(" +");
      for (int column = 0; column < tokens.length; column++) {
        map.put(Integer.parseInt(tokens[column]), Position.of(column, row));
      }
    }

    return new Grid(map, size);
  }
}
