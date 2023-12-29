package fpc.aoc.year2020.day15;

import lombok.NonNull;

public interface History {

  @NonNull
  NumberHistory get(int lastSpoken);

  void initialize(int[] initialNumbers);

  void updateNumberHistory(int nextToSay, int turnIndex);

}
