package fpc.aoc.common;

public record IntRange(int inf, int sup) {


  public boolean contains(IntRange other) {
    return this.inf <= other.inf && this.sup >= other.sup;
  }

  public boolean overlapsWith(IntRange other) {
    return !(this.inf > other.sup || this.sup < other.inf);
  }


}
