package fpc.aoc.common;

import lombok.NonNull;

public record IntRange(int inf, int sup) {


  public boolean contains(@NonNull IntRange other) {
    return this.inf <= other.inf && this.sup>=other.sup;
  }

  public boolean overlapsWith(@NonNull IntRange other) {
    return !(this.inf > other.sup || this.sup < other.inf);
  }


}
