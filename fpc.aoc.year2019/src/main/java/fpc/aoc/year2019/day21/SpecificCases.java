package fpc.aoc.year2019.day21;

import fpc.aoc.common.Table;

import java.util.Optional;

/**
 * @author perococco
 **/
public class SpecificCases {

  private static final Table<Integer, Integer, Action> SPECIFIC_CASES;

  static {
    SPECIFIC_CASES = Table.create();
    SPECIFIC_CASES.put(4, 0b1001, Action.JUMP);
    SPECIFIC_CASES.put(4, 0b1011, Action.JUMP);
    SPECIFIC_CASES.put(9, 0b110101011, Action.JUMP);
  }

  public static Optional<Action> getSpecificCases(int sensorRange, int ground) {
    return Optional.ofNullable(SPECIFIC_CASES.get(sensorRange, ground));
  }

}
