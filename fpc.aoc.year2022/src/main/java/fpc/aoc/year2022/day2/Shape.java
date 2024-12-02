package fpc.aoc.year2022.day2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The order is important
 */
@RequiredArgsConstructor
@Getter
public enum Shape {
  ROCK(1),
  PAPER(2),
  SCISSORS(3),
  ;

  private final int score;

  public OutCome getOutCome(Shape other) {
    if (this == other) {
      return OutCome.DRAW;
    }
    if (other == Holder.WORSE[ordinal()]) {
      return OutCome.WIN;
    }
    return OutCome.LOSS;
  }

  public Shape getBetter() {
    return Holder.BETTER[ordinal()];
  }

  public Shape getWorse() {
    return Holder.WORSE[ordinal()];
  }


  private static class Holder {

    public static final Shape[] BETTER = {PAPER, SCISSORS, ROCK};
    public static final Shape[] WORSE = {SCISSORS, ROCK, PAPER};
  }


}
