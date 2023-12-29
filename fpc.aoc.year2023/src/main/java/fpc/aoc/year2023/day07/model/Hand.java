package fpc.aoc.year2023.day07.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;

@RequiredArgsConstructor
public class Hand {
  private final Type type;
  private final String text;
  private final int[] hand;
  @Getter
  private final int bid;


  public static final Comparator<? super Hand> COMPARATOR = (Comparator<Hand>) (o1, o2) -> {
    if (o1 == o2) {
      return 0;
    }
    int result = o1.type.value() - o2.type.value();
    if (result != 0) {
      return result;
    }

    for (int i = 0; i < o1.hand.length; i++) {
      result = o1.hand[i] - o2.hand[i];
      if (result != 0) {
        return result;
      }
    }
    return 0;
  };

  @Override
  public String toString() {
    return text + " " + bid;
  }
}
