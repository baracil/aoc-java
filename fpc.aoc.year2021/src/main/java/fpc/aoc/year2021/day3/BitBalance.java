package fpc.aoc.year2021.day3;

public enum BitBalance {
  MORE_ONES,
  MORE_ZEROES,
  SAME,
  ;

  public static BitBalance fromBalanceCount(int count) {
    if (count == 0) {
      return SAME;
    } else if (count < 0) {
      return MORE_ZEROES;
    }
    return MORE_ONES;
  }
}
