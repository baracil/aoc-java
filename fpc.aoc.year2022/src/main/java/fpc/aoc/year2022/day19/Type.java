package fpc.aoc.year2022.day19;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Type {
  ORE(0),
  CLAY(1),
  OBSIDIAN(2),
  GEODE(3),
  ;
  public final int index;


}
