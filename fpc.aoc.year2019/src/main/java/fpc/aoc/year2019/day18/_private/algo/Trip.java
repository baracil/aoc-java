package fpc.aoc.year2019.day18._private.algo;

import fpc.aoc.year2019.day18._private.Key;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@Getter
@Value
public class Trip {

  @NonNull Key from;

  @NonNull Key to;

  @Override
  public String toString() {
    return "Trip( " + from.id() + " -> " + to.id() + " )";
  }
}
