package fpc.aoc.year2022.day19;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Type {
  ORE(0),
  CLAY(1),
  OBSIDIAN(2),
  GEODE(3),
  ;
  @Getter
  public final int index;


}
