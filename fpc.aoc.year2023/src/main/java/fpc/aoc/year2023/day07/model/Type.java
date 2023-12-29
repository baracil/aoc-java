package fpc.aoc.year2023.day07.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Type {
  HIGH_CARD(0),
  ONE_PAIR(1),
  TWO_PAIR(2),
  THREE_OF_A_KIND(3),
  FULL_HOUSE(4),
  FOUR_OF_A_KIND(5),
  FIVE_OF_A_KIND(6),
  ;
  private final int value;


}
