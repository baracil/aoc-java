package fpc.aoc.year2021.day4.struct;

public sealed interface GridState {

  record Winning(int score) implements GridState {
  }

  record NotWinning() implements GridState {
  }
}
