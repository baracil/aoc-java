package fpc.aoc.day14.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Type {
  EMPTY("."),
  CUBE("#"),
  LIMIT("="),
  ROUND("O"),
  ;
  private final String chr;
}
