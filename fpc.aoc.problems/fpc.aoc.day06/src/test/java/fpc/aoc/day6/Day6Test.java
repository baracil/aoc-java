package fpc.aoc.day6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day6Test {

  public static final String TEST_INPUT = """
  Time:      7  15   30
  Distance:  9  40  200
  """;

  @Test
  public void testPart1() {
    final var actual = new Day6Part1Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(288L, actual);
  }

  @Test
  public void testPart2() {
    final var actual = new Day6Part2Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(71503L, actual);
  }


}
