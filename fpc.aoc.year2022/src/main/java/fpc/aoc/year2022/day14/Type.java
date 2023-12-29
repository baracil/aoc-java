package fpc.aoc.year2022.day14;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Type {
  ROCK('█'),
  SAND('o'),
  EMPTY('.'),
  ;

  private final char chr;
}
